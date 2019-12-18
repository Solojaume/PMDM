package com.example.solobici;
;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public class VistaJuego extends View {
    // BICI //
    private Grafico bici;
    private int giroBici;	//Incremento en la dirección de la bici
    private float aceleracionBici;	//Aumento de velocidad en la bici
    private static final int PASO_GIRO_BICI = 5;
    private static final float PASO_ACELERACION_BICI = 1.5f;

    // THREAD Y TIEMPO //
    //Hilo encargado de procesar el tiempo
    private HiloJuego hiloJuego;
    //Tiempo que debe transcurrir para procesar cambios (ms)
    private static int PERIODO_PROCESO = 50;
    //Momento en el que se realizó el último proceso
    private long ultimoProceso = 0;

    // PANTALLA TÁCTIL //
    // Las variables mX y mY se utilizarán para recordar
    // las coordenadas del último evento.
    private float mX=0, mY=0;
    private boolean disparo=false;

    // RUEDA //
    private Grafico rueda;
    private static int VELOCIDAD_RUEDA = 12;
    private boolean ruedaActiva;
    private int distanciaRueda;

    // VARIABLES GLOBALES //
    //Controlar si la aplicación está en segundo plano
    private boolean corriendo = false;
    //Controlar si la aplicación está en pausa
    private boolean pausa;

    public VistaJuego(Context contexto, AttributeSet atributos) {
        super(contexto, atributos);
        Drawable graficoBici,  graficoRueda;

        //BICI
        graficoBici = contexto.getResources().getDrawable(R.drawable.bici);
        bici = new Grafico(this, graficoBici);
        // CONTROL DEL HILO DEL JUEGO
        corriendo = true;

        // RUEDA

        graficoRueda = contexto.getResources().getDrawable(R.drawable.rueda);

        rueda = new Grafico(this, graficoRueda);
        ruedaActiva = false;

    }
    //Al comenzar y dibujar por primera vez la pantalla del juego
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //Para la bici ponemos la posición central de la pantalla
        bici.setPosX((w-bici.getAncho())/2);
        bici.setPosY((h-bici.getAlto())/2);

        //HILO QUE CONTROLA EL JUEGO
        hiloJuego = new HiloJuego();
        hiloJuego.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Dibujamos la bici
        bici.dibujaGrafico(canvas);
        //Dibujamos la rueda si lo indica la variable ruedaActiva
        if (ruedaActiva)
            rueda.dibujaGrafico(canvas);
    }

    protected synchronized void actualizaMovimiento() {
        long ahora = System.currentTimeMillis();
        // No hacemos nada si el período de proceso no se ha cumplido.
        if (ultimoProceso + PERIODO_PROCESO > ahora) {
            return;
        }
        // Para una ejecución en tiempo real calculamos retardo
        double retardo = (ahora - ultimoProceso) / PERIODO_PROCESO;
        // Actualizamos la posición de la bici
        bici.setAngulo((int) (bici.getAngulo() + giroBici * retardo));
        double nIncX = bici.getIncX() + aceleracionBici
                * Math.cos(Math.toRadians(bici.getAngulo())) * retardo;
        double nIncY = bici.getIncY() + aceleracionBici
                * Math.sin(Math.toRadians(bici.getAngulo())) * retardo;
        if (Grafico.distanciaE(0, 0, nIncX, nIncY) <= Grafico.getMaxVelocidad()) {
            bici.setIncX(nIncX);
            bici.setIncY(nIncY);
        }
        bici.incrementaPos();
        bici.setIncX(0);
        bici.setIncY(0);

        ultimoProceso = ahora;

        if (ruedaActiva) { //Movemos la rueda
            rueda.incrementaPos();
            distanciaRueda--;
            if (distanciaRueda<0) {
                ruedaActiva = false;
            }
        }
    } // del metodo actualizaMovimiento

    private class HiloJuego extends Thread {
        @Override
        public void run() {
            while (true) {
                while (corriendo) {
                    actualizaMovimiento();
                }
            }
        }
    }
    // TODA LA GESTION DE Teclado y Pantalla Taltil
    @Override
    public boolean onKeyDown(int codigoTecla, KeyEvent evento) {
        super.onKeyDown(codigoTecla, evento);
        //Procesamos la pulsación
        boolean pulsacion=true;
        switch (codigoTecla) {
            case KeyEvent.KEYCODE_DPAD_UP:
                aceleracionBici=+PASO_ACELERACION_BICI;
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                giroBici=-PASO_GIRO_BICI;
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                giroBici=+PASO_GIRO_BICI;
                break;
            case KeyEvent.KEYCODE_DPAD_CENTER:
            case KeyEvent.KEYCODE_ENTER:
                lanzarRueda();
                break;
            default:
                //Si estamos aquí no hemos pulsado nada que nos interese
                pulsacion=false;
                break;
        }
        return pulsacion;
    }

    @Override
    public boolean onKeyUp(int codigoTecla, KeyEvent evento) {
        super.onKeyUp(codigoTecla, evento);
        //Procesamos la pulsación
        boolean pulsacion=true;
        switch (codigoTecla) {
            case KeyEvent.KEYCODE_DPAD_UP:
                //aceleracionBici=0;
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                giroBici=0;
                break;
            default:
                //Si estamos aquí, no hemos pulsado nada que interese
                pulsacion=false;
                break;
        }
        return pulsacion;
    }

    @Override
    public boolean onTouchEvent(MotionEvent evento) {
        super.onTouchEvent(evento);
        //Obtenemos la posición de la pulsación
        float x=evento.getX();
        float y=evento.getY();
        switch (evento.getAction()) {
            //Al comenzar pulsación (ACTION_DOWN) se activa la variable disparo
            case MotionEvent.ACTION_DOWN:
                disparo=true;
                break;
            //Comprobar pulsación continuada con desplazamiento hor/ver.
            //Si es asi, desactivamos disparo: se tratará de un movimiento
            //se trata de un movimiento en vez de  un disparo.
            case MotionEvent.ACTION_MOVE:
                float dx=Math.abs(x-mX);
                float dy=Math.abs(y-mY);
                //Un desplazamiento del dedo horizontal hace girar la bici.
                if (dy<6 && dx>6)
                {
                    giroBici = Math.round((x-mX)/2);
                    disparo = false;
                } else //Un desplazamiento vertical produce una aceleración.
                    if (dx<6 && dy>6)
                    {
                        aceleracionBici = Math.round((mY-y)/25);
                        disparo = false;
                    }
                break;
            //Si se levanta el dedo (ACTION_UP) sin haberse producido desplazamiento horizontal o vertical
            //disparo estará activado y lo que hacemos es disparar
            case MotionEvent.ACTION_UP:
                giroBici = 0;
                aceleracionBici = 0;
                if (disparo){
                    lanzarRueda();
                }
                break;
        }
        mX=x; mY=y;
        return true;
    }




    private void lanzarRueda() {
        rueda.setPosX(bici.getPosX() + bici.getAncho()/2 - rueda.getAncho()/2);
        rueda.setPosY(bici.getPosY() + bici.getAlto()/2 - rueda.getAlto()/2);
        rueda.setAngulo(bici.getAngulo());
        rueda.setIncX(Math.cos(Math.toRadians(rueda.getAngulo())) * VELOCIDAD_RUEDA);
        rueda.setIncY(Math.sin(Math.toRadians(rueda.getAngulo())) * VELOCIDAD_RUEDA);
        distanciaRueda = (int)Math.min(
                this.getWidth() / Math.abs(rueda.getIncX()),
                this.getHeight() / Math.abs(rueda.getIncY())) - 2;
        ruedaActiva = true;
    }

    public HiloJuego getHilo(){
        return hiloJuego;
    }

    public void setCorriendo(boolean corriendo) {
        this.corriendo = corriendo;
    }

    public void setPausa(boolean pausa) {
        this.pausa = pausa;
    }
}
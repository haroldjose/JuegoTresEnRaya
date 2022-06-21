import java.util.Scanner;

public class TresEnRaya {


    char[][] tablero = new char[3][3];
    char primerJugador = 'X';
    char maquinaJugador = 'O';
    char vacio = '-';
    boolean turno = true;
    boolean primerMovimiento = true;
    int actualFilaMaquina = 0;
    int actualColumnaMaquina = 0;


    private void inicializarTablero() {

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = vacio;
            }
        }

    }

    public boolean partidaTerminada() {
        if (tableroLleno() || juegolinea() != vacio || juegoColumna() != vacio || juegoDiagonal() != vacio) {
            return true;
        }
        return false;
    }

    public boolean tableroLleno() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == vacio) {
                    return false;
                }
            }
        }
        return true;
    }

    private char juegolinea() {
        char simbolo;
        boolean coincidencia;

        for (int i = 0; i < tablero.length; i++) {
            coincidencia = true;
            simbolo = tablero[i][0];
            if (simbolo != vacio) {
                for (int j = 1; j < tablero[0].length; j++) {
                    if (simbolo != tablero[i][j]) {
                        coincidencia = false;
                    }
                }
                if (coincidencia) {
                    return simbolo;
                }
            }

        }
        return vacio;
    }

    private char juegoColumna() {
        char simbolo;
        boolean coincidencia;

        for (int j = 0; j < tablero.length; j++) {
            coincidencia = true;
            simbolo = tablero[0][j];
            if (simbolo != vacio) {
                for (int i = 1; i < tablero[0].length; i++) {
                    if (simbolo != tablero[i][j]) {
                        coincidencia = false;
                    }
                }
                if (coincidencia) {
                    return simbolo;
                }
            }

        }
        return vacio;
    }

    private char juegoDiagonal() {
        char simbolo;
        boolean coincidencia = true;
        simbolo = tablero[0][0];
        if (simbolo != vacio) {
            for (int i = 1; i < tablero.length; i++) {
                if (simbolo != tablero[i][i]) {
                    coincidencia = false;
                }
            }
            if (coincidencia) {
                return simbolo;
            }
        }
        coincidencia = true;

        simbolo = tablero[0][2];
        if (simbolo != vacio) {
            for (int i = 1, j = 1; i < tablero.length; i++, j--) {
                if (simbolo != tablero[i][j]) {
                    coincidencia = false;
                }
            }
            if (coincidencia) {
                return simbolo;
            }
        }
        return vacio;
    }

    public void verGanador() {
        char simbolo = juegolinea();
        if (simbolo != vacio) {
            mostrarGanador(simbolo, 1);
            return;
        }

        simbolo = juegoColumna();
        if (simbolo != vacio) {
            mostrarGanador(simbolo, 2);
            return;
        }

        simbolo = juegoDiagonal();
        if (simbolo != vacio) {
            mostrarGanador(simbolo, 3);
            return;
        }
        System.out.println("Juego empatado");
    }

    private void mostrarGanador(char simbolo, int tipo) {

        switch (tipo) {
            case 1:
                if (simbolo == primerJugador) {
                    System.out.println("Felicidades ganaste la partida!!");
                } else {
                    System.out.println("Lo siento perdiste, te ganaron!!!!!");
                }
                break;
            case 2:
                if (simbolo == primerJugador) {
                    System.out.println("Felicidades ganaste la  partida!!");
                } else {
                    System.out.println("Lo siento perdiste, te ganaron!!!!!");
                }
                break;
            case 3:
                if (simbolo == primerJugador) {
                    System.out.println("Felicidades es ganaste la partida!!");
                } else {
                    System.out.println("Lo siento perdiste, te ganaron!!!!!");
                }
                break;
        }
    }

    public void insertarEnTabla(int fila, int columna) {
        if (turno) {
            this.tablero[fila][columna] = primerJugador;
        } else {
            this.tablero[fila][columna] = maquinaJugador;
        }

    }

    public void mostrarTablero() {
        for (int i = 0; i < this.tablero.length; i++) {
            for (int j = 0; j < this.tablero[0].length; j++) {
                System.out.print(this.tablero[i][j] + " ");
            }
            System.out.println("\n ");
        }
    }

    public void turnoJugador() {
        if (turno) {
            System.out.println("Es tu turno puedes jugar");
        } else {
            System.out.println("Es turno de la maquina");
        }
    }

    public void cambiarTurno() {
        this.turno = !this.turno;

    }

    // verificar si esta con dicion puede entrar en otro metodo
    public boolean validarPosicion(int fila, int columna) {
        if (fila >= 0 && fila < tablero.length && columna >= 0 && columna < tablero.length) {
            return true;
        } else {
            return false;
        }
    }

    // verificar si esta con dicion puede entrar en otro metodo
    public boolean valorPosicion(int fila, int columna) {
        if (tablero[fila][columna] != vacio) {
            System.out.println(tablero[fila][columna]);
            return true;
        } else {
            return false;
        }
    }

    public boolean jugadorM() {
        if (primerMovimiento) {
            for (int indiceColumna = 0; indiceColumna < tablero.length; indiceColumna++) {
                for (int indiceFila = 0; indiceFila < tablero.length; indiceFila++) {
                    if (!valorPosicion(indiceFila,indiceColumna)) {
                        actualFilaMaquina = indiceFila;
                        actualColumnaMaquina = indiceColumna;
                        return true;
                    }
                }
            }
        }
        if (tablero[0][0] == primerJugador && tablero[0][1] == primerJugador) {
            actualFilaMaquina = 0;
            actualColumnaMaquina = 2;
            return validarPosicion(0, 2);
        }
        if (tablero[0][0] == primerJugador && tablero[0][2] == primerJugador) {
            actualFilaMaquina = 0;
            actualColumnaMaquina = 1;
            return validarPosicion(0, 1);
        }
        if (tablero[0][2] == primerJugador && tablero[0][1] == primerJugador) {
            actualFilaMaquina = 0;
            actualColumnaMaquina = 0;
            return validarPosicion(0, 0);
        }
        //
        if (tablero[1][0] == primerJugador && tablero[1][1] == primerJugador) {
            actualFilaMaquina = 1;
            actualColumnaMaquina = 2;
            return validarPosicion(1, 2);
        }
        if (tablero[1][0] == primerJugador && tablero[1][2] == primerJugador) {
            actualFilaMaquina = 1;
            actualColumnaMaquina = 1;
            return validarPosicion(1, 1);
        }
        if (tablero[1][2] == primerJugador && tablero[1][1] == primerJugador) {
            actualFilaMaquina = 1;
            actualColumnaMaquina = 0;
            return validarPosicion(1, 0);
        }
        ////
        if (tablero[0][0] == primerJugador && tablero[1][1] == primerJugador) {
            actualFilaMaquina = 2;
            actualColumnaMaquina = 2;
            return validarPosicion(2, 2);
        }
        if (tablero[0][0] == primerJugador && tablero[2][2] == primerJugador) {
            actualFilaMaquina = 1;
            actualColumnaMaquina = 1;
            return validarPosicion(1, 1);
        }
        if (tablero[2][2] == primerJugador && tablero[1][1] == primerJugador) {
            actualFilaMaquina = 0;
            actualColumnaMaquina = 0;
            return validarPosicion(0, 0);
        }
        //
        if (tablero[2][0] == primerJugador && tablero[1][1] == primerJugador) {
            actualFilaMaquina = 0;
            actualColumnaMaquina = 2;
            return validarPosicion(0, 2);
        }
        if (tablero[2][0] == primerJugador && tablero[0][2] == primerJugador) {
            actualFilaMaquina = 1;
            actualColumnaMaquina = 1;
            return validarPosicion(1, 1);
        }
        if (tablero[0][2] == primerJugador && tablero[1][1] == primerJugador) {
            actualFilaMaquina = 2;
            actualColumnaMaquina = 0;
            return validarPosicion(2, 0);
        }
        ////

        if (tablero[0][0] == primerJugador && tablero[1][0] == primerJugador) {
            actualFilaMaquina = 2;
            actualColumnaMaquina = 0;
            return validarPosicion(2, 0);
        }
        if (tablero[0][0] == primerJugador && tablero[2][0] == primerJugador) {
            actualFilaMaquina = 1;
            actualColumnaMaquina = 0;
            return validarPosicion(1, 0);
        }
        if (tablero[2][0] == primerJugador && tablero[1][0] == primerJugador) {
            actualFilaMaquina = 0;
            actualColumnaMaquina = 0;
            return validarPosicion(0, 0);
        }
        //
        if (tablero[0][1] == primerJugador && tablero[1][1] == primerJugador) {
            actualFilaMaquina = 2;
            actualColumnaMaquina = 1;
            return validarPosicion(2, 1);
        }
        if (tablero[1][1] == primerJugador && tablero[2][1] == primerJugador) {
            actualFilaMaquina = 0;
            actualColumnaMaquina = 1;
            return validarPosicion(0, 1);
        }
        if (tablero[2][1] == primerJugador && tablero[0][1] == primerJugador) {
            actualFilaMaquina = 1;
            actualColumnaMaquina = 1;
            return validarPosicion(1, 1);
        }
        //
        if (tablero[0][2] == primerJugador && tablero[1][2] == primerJugador) {
            actualFilaMaquina = 2;
            actualColumnaMaquina = 2;
            return validarPosicion(2, 2);
        }
        if (tablero[1][2] == primerJugador && tablero[2][2] == primerJugador) {
            actualFilaMaquina = 0;
            actualColumnaMaquina = 2;
            return validarPosicion(0, 2);
        }
        if (tablero[0][2] == primerJugador && tablero[2][2] == primerJugador) {
            actualFilaMaquina = 1;
            actualColumnaMaquina = 2;
            return validarPosicion(1, 2);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        TresEnRaya nuevojuego = new TresEnRaya();
        int fila = 0;
        int columna = 0;

        boolean posValida, correcto;
        nuevojuego.inicializarTablero();
        while (!nuevojuego.partidaTerminada()) {
            do {
                // muestra si es turno del jugador o la maquina
                nuevojuego.turnoJugador();

                // muestra el tablero
                nuevojuego.mostrarTablero();
                correcto = false;

                if (nuevojuego.turno) {
                    System.out.println("ingresa la fila [0 ~ 2]: ");
                    fila = src.nextInt();
                    System.out.println("ingresa la columna [0 ~ 2]: ");
                    columna = src.nextInt();
                    posValida = nuevojuego.validarPosicion(fila, columna);
                    if (posValida) {
                        if (!nuevojuego.valorPosicion(fila, columna)) {
                            correcto = true;
                        } else {
                            System.out.println("Existe un valor en la posicion");
                        }
                    } else {
                        System.out.println("posicion no valida");
                    }
                } else {
                    posValida = nuevojuego.jugadorM();
                    if (posValida) {
                        fila = nuevojuego.actualFilaMaquina;
                        columna = nuevojuego.actualColumnaMaquina;
                        if (nuevojuego.validarPosicion(fila, columna)) {
                            correcto = true;
                            nuevojuego.primerMovimiento =false;
                        } else {
                            System.out.println("Existe un valor en la posicion");
                        }
                    } else {
                        System.out.println("posicion no valida");
                    }
                }
            } while (!correcto);
            nuevojuego.insertarEnTabla(fila, columna);
            nuevojuego.cambiarTurno();
        }
        nuevojuego.mostrarTablero();
        nuevojuego.verGanador();
    }
}

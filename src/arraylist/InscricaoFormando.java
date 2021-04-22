package arraylist;

import java.util.ArrayList;

class InscricaoFormando {
    private int idFormando;
    private int idCurso;

    public InscricaoFormando() {
    }

    public InscricaoFormando(int idFormando, int idCurso) {
        this.idFormando = idFormando;
        this.idCurso = idCurso;
    }

    public int getIdFormando() {
        return idFormando;
    }

    public void setIdFormando(int idFormando) {
        this.idFormando = idFormando;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public String toString() {
        return "InscricaoFormando{" + "idFormando=" + idFormando + ", idCurso=" + idCurso + '}';
    }
    
}

package arraylist;

class InscricaoDisciplina {
    private int idDisciplina;
    private int idCurso;

    public InscricaoDisciplina() {
    }

    public InscricaoDisciplina(int idDisciplina, int idCurso) {
        this.idDisciplina = idDisciplina;
        this.idCurso = idCurso;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public String toString() {
        return "InscricaoDisciplina{" + "idDisciplina=" + idDisciplina + ", idCurso=" + idCurso + '}';
    }
    
}

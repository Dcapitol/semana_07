package semana_07;

public class ArregloCodigos {
    private int[] codigo;
    private int indice;

    public ArregloCodigos() {
        codigo = new int[10];
        indice = 0;
    }

    public int tamaño() {
        return indice;
    }

    public int obtener(int i) {
        return codigo[i];
    }

    private void ampliarArreglo() {
		int[] aux = codigo;
		codigo = new int[indice + 10];
		for (int i=0; i<indice; i++)
			codigo[i] = aux[i];
	}

    public void adicionar(int numero) {
        if (indice == codigo.length) 
            ampliarArreglo();
        codigo[indice] = numero;
        indice++;
    }

    public boolean intercambiarSegPen() {
        if (indice < 2) {
            return false; 
        } else {
            int temp = codigo[1];
            codigo[1] = codigo[indice - 2];
            codigo[indice - 2] = temp;
            return true; 
        }
    }

    public boolean eliminarPrimero() {
        if (indice == 0) {
            return false;
        } else {
            for (int i = 0; i < indice - 1; i++) {
                codigo[i] = codigo[i + 1];
            }
            indice--;
            return true; 
        }
    }

    public int posCodigo() {
        for (int i = indice - 1; i >= 0; i--) {
            if (codigo[i] >= 1000 && codigo[i] <= 1111) {
                return i;
            }
        }
        return -1; 
    }

    public boolean intercambiarCodigo() {
        int pos = posCodigo();
        if (pos == -1) {
            return false; 
        } else {
            int ultCod = codigo[pos];
            for (int i = 0; i < indice; i++) {
                if (codigo[i] == ultCod) {
                    codigo[i] = codigo[2];
                    codigo[2] = ultCod;
                    return true; 
                }
            }
        }
        return false; 
    }

    public boolean eliminarCodigo() {
        int pos = posCodigo();
        if (pos == -1) {
            return false;
        } else {
            for (int i = pos; i < indice - 1; i++) {
                codigo[i] = codigo[i + 1];
            }
            indice--;
            return true;
        }
    }

}

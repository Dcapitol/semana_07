package semana_07;

public class ArregloEdades {

	// Atributos privados
	private int[] edad;
	private int indice;

	// Constructor
	public ArregloEdades() {
		edad = new int[10];
		indice = 0;
	}

	// Operaciones públicas básicas
	public int tamanio() {
		return indice;
	}

	public int obtener(int i) {
		return edad[i];
	}

	public void adicionar(int numero) {
		if (indice == edad.length)
			ampliarArreglo();
		edad[indice] = numero;
		indice++;
	}

	// Operaciones públicas complementarias
	public void eliminarAlFinal() {
		indice--;
	}

	public void eliminarTodo() {
		indice = 0;
	}

	// Operaciones privadas
	private void ampliarArreglo() {
		int[] aux = edad;
		edad = new int[indice + 10];
		for (int i = 0; i < indice; i++)
			edad[i] = aux[i];
	}

	public int posPrimeraEdadAdolescente() {
		int i = 0;
		for (int valor : edad) {
			if (valor >= 12 && valor <= 20) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public int posUltimaEdadAdolescente() {
		for (int i = indice - 1; i >= 0; i--) {
			if (edad[i] >= 12 && edad[i] <= 20) {
				return i;
			}
		}
		return -1;
	}
	private void intercambiar(int pos1, int pos2) {
		int aux = edad[pos1];
		edad[pos1] = edad[pos2];
		edad[pos2] = aux;
	}
	public void intercambiarEdadesAdolescentesExtremas(){
		int pos01 = posPrimeraEdadAdolescente();
		int pos02 = posUltimaEdadAdolescente();
		if(pos01!=-1 && pos02 !=-1){			
			intercambiar(pos01,pos02);
		}
	}
	public void remplazarPrimeraEdadAdolescente(){
		int pos01 = posPrimeraEdadAdolescente();
		int pos02 = posUltimaEdadAdolescente();
		if(pos01!=-1 && pos02 !=-1){
			edad[pos01] = edad[pos02];
		}	
	}
	private void eliminar(int pos) {
		for (int i=pos; i<indice-1; i++){
			edad[i] = edad[i+1];
		}
		indice --;
	}
	public void eliminarPrimeraEdadAdolescente(){
		int pos01 = posPrimeraEdadAdolescente();
		if(pos01!=-1){
			eliminar(pos01);
		}
	}

}
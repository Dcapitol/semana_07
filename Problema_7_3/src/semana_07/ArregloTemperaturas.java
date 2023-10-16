package semana_07;

public class ArregloTemperaturas {
	
	//  Atributos privados
	private double[] temperatura;
	private int indice;
	//  Constructor
	public ArregloTemperaturas() {
		temperatura = new double[10];
		indice = 0;
	}
	//  Operaciones públicas básicas
	public int tamanio() {
		return indice;
	}
	public double obtener(int i) {
		return temperatura[i];
	}
	public void adicionar(double numero) {
		if (indice == temperatura.length)
			ampliarArreglo();
		temperatura[indice] = numero;
		indice ++;
	}
	//  Operaciones públicas complementarias
	public void eliminarAlFinal() {
		indice --;
	}
	public void eliminarTodo() {
		indice = 0;
	}
	//  Operaciones privadas
	private void ampliarArreglo() {
		double[] aux = temperatura;
		temperatura = new double[indice + 10];
		for (int i=0; i<indice; i++)
			temperatura[i] = aux[i];
	}
	
	public double temperaturaPromedio() {
		if (indice == 0) {
			return 0;
		}
		double suma = 0.0;
		for (int i = 0; i < indice; i++) {
			suma += temperatura[i];
		}
		return suma / indice;
	}
	
	public int posPrimeraTemperaturaFebril() {
		for (int i = 0; i < indice; i++) {
			if (temperatura[i] > 37.2) {
				return i;
			}
		}
		return -1;
	}
	
	public int posUltimaTemperaturaFebril() {
		for (int i = indice - 1; i >= 0; i--) {
			if (temperatura[i] > 37.2) {
				return i;
			}
		}
		return -1;
	}
	
	public void remplazarPrimeraTemperaturaFebril() {
		int posPrimera = posPrimeraTemperaturaFebril();
		int posUltima = posUltimaTemperaturaFebril();
		if (posPrimera != -1 && posUltima != -1) {
			temperatura[posPrimera] = temperatura[posUltima];
		}
	}
	
	public void remplazarUltimaTemperaturaFebril() {
		int posUltima = posUltimaTemperaturaFebril();
		double promedio = temperaturaPromedio();
		if (posUltima != -1) {
			temperatura[posUltima] = promedio;
		}
	}
	
	public void eliminarPrimeraTemperaturaFebril() {
		int posPrimera = posPrimeraTemperaturaFebril();
		if (posPrimera != -1) {
			for (int i = posPrimera; i < indice - 1; i++) {
				temperatura[i] = temperatura[i + 1];
			}
			indice--;
		}
	}
}

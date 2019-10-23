package testing;

public class TestClass {

	private static int countingValleys(int n, String s) {

        int seaLevel = 0;

        int qtyValleys = 0;

        int i;

        System.out.println("Cantidad de Pasos: " + n);
        System.out.println("Recorrido: " + s);
        
        
        for(i = 0; i < s.length(); i ++){

        	System.out.println("Iter I en posici�n: " + i);
        	
            char step = s.charAt(i);

            System.out.println("Estamos dando el paso: " + step);
            
            
            if(step == 'D' && seaLevel == 0){

                seaLevel -= 1;
                qtyValleys += 1;

                System.out.println("Estamos recorriendo el valle n�mero: " + qtyValleys);
                System.out.println("Estamos en el nivel del mar n�mero: " + seaLevel);
                
                //En esta parte itero el valle, hasta llegar de nuevo al nivel del mar
                //Para no volver a contar ese valle.
                int j;
                for(j = i + 1; seaLevel < 0; j++){
                    
                	System.out.println("****Iterando valle****");
                	
                	System.out.println("valor de j: " + j);
                	
                    char valleyStep = s.charAt(j);

                    System.out.println("Dando paso en el valle: " + valleyStep);
                    
                    if(valleyStep == 'D'){
                        seaLevel -= 1;
                    }else{
                        seaLevel += 1;
                    }
                    
                    System.out.println("Nivel del mar: " + seaLevel);
                }
                
                System.out.println("Si llegamos ac� significa que estamos en el nivel 0 del mar");
                
                i = j - 1;
                
                System.out.println("Valor del iter i en el nivel cero del valle: " + i);

            }else if(step == 'U' && seaLevel == 0){
                
                seaLevel += 1;

                System.out.println("Estamos en una montania");
                
                System.out.println("Estamos en el nivel del mar n�mero: " + seaLevel);
                
                int k;

                for(k = i + 1; seaLevel > 0; k++){

                    char mountainStep = s.charAt(k);

                	System.out.println("****Iterando montania****");
                	
                	System.out.println("valor de k: " + k);
                    
                    if(mountainStep == 'U'){
                        seaLevel += 1;
                    }else{
                        seaLevel -= 1;
                    }
                    
                    System.out.println("Nivel del Mar: " + seaLevel);
                }

                System.out.println("Terminamos de iterar la montania");
                
                i = k - 1;
                
                System.out.println("La iter i, quedo con valor: " + i);
            }            
        }

        
        
        return qtyValleys;
    }
	
//	public static void main(String[] args) {
//		
//		String recorrido = "DDDDDDDDUUUUUUUUDU";
//		
//		int pasos = recorrido.length();
//		
//		
//		
////		String recorrido = "DUDDUU";
//		
//		System.out.println("Cantidad de Valles recorridos: " 
//					+ countingValleys(pasos, recorrido));
//		
//		int[] array = new int[3];
//		array[0] = 1;
//		array[1] = 1;
//		array[2] = 1;
//		
//		System.out.println(array.length);
//	}	
	
	private static final int saltos(int[] c) {
		
        int size = c.length;

        int minorQty = 0;

        int jumpSize = 0;

        for(int i = 0; i < size; i += jumpSize){

        	jumpSize = 1;
        	
        	//Si hay dos nubes disponibles, evaluo si puedo saltar dos.
            if(hasTwoCloudsAvailable(i + 1, size)){

                if(c[i+2] == 0){
                    jumpSize = 2;
                }            
            }
            
            //Si estoy parado en la �ltima nube, significa que gan�, por lo tanto no salto.
            if(i != (size - 1)) {
                minorQty += 1;           	
            }
        }

        return minorQty;
		
	}

    private static final boolean hasTwoCloudsAvailable(int actual, int qtyClouds){
        return  (qtyClouds - actual) >= 2 ;
    }

	
	public static void main(String[] args) {
		
		//System.out.println("resultado: "+  repeatedString("bba", Long.valueOf("10")));
		int[][] matriz = new int[6][6];
		
		matriz[0][0] = 1;
		matriz[0][1] = 10;
		matriz[0][2] = 11;
		matriz[0][3] = 13;
		matriz[0][4] = 14;
		matriz[0][5] = 15;
		
		matriz[1][0] = 10;
		matriz[1][1] = -1;
		matriz[1][2] = 2;
		matriz[1][3] = 4;
		matriz[1][4] = 5;
		matriz[1][5] = 6;
		matriz[1][0] = 21;
		
		matriz[2][0] = 21;
		matriz[2][1] = 31;
		matriz[2][2] = 16;
		matriz[2][3] = 17;
		matriz[2][4] = 18;
		matriz[2][5] = 19;
		
		matriz[3][0] = 11;
		matriz[3][1] = 12;
		matriz[3][2] = 13;
		matriz[3][3] = 14;
		matriz[3][4] = 15;
		matriz[3][5] = 31;
		
		matriz[4][0] = 41;
		matriz[4][1] = 51;
		matriz[4][2] = 61;
		matriz[4][3] = -10;
		matriz[4][4] = 1;
		matriz[4][5] = 1;

		matriz[5][0] = 100;
		matriz[5][1] = 101;
		matriz[5][2] = 21;
		matriz[5][3] = 71;
		matriz[5][4] = 81;
		matriz[5][5] = 91;
	
//		System.out.println("valor maximo de la matriz: " + hourglassSum(matriz));
		
		
		int[] array = new int[3];
		
		array[0] = 1;
		array[1] = 2;
		array[2] = 3;	
		
//		System.out.println("Primero mostramos el array a procesar: ");
//		imprimirArray(array);
//		
//		System.out.println("rotando el aray " + 0 + " veces: " + rotLeft(array, 0));
//		
//		System.out.println("rotando el aray " + 1 + " veces: " + rotLeft(array, 1));
//		
//		System.out.println("rotando el aray " + 2 + " veces: " + rotLeft(array, 2));
//
//		System.out.println("rotando el aray " + 3 + " veces: " + rotLeft(array, 3));
//		
//		System.out.println("rotando el aray " + 4 + " veces: " + rotLeft(array, 4));
//		
//		System.out.println("rotando el aray " + 5 + " veces: " + rotLeft(array, 5));
//		
//		System.out.println("rotando el aray " + 6 + " veces: " + rotLeft(array, 6));
//		
//		System.out.println("rotando el aray " + 7 + " veces: " + rotLeft(array, 7));
		
		int[] ar = new int[5];
		
		ar[0] = 1;
		ar[1] = 2;
		ar[2] = 3;
		ar[3] = 4;
		ar[4] = 5;
		
//		rotLeft(ar, 4);
		
		int[] brives = new int[8];
		
		brives[0] = 6;
		brives[1] = 3;
		brives[2] = 2;
		brives[3] = 5;
		brives[4] = 7;
		brives[5] = 4;
		brives[6] = 8;
		brives[7] = 1;
		
		System.out.println("Array original: \r\n");
		
		imprimirArray(brives);
		System.out.println("\r\n \r\n +++++++++++++++++++++++++++");
		minimumBribes(brives);
		
	}
	
	static void imprimirArray(int[] array){
		
		String value = "";
		for(int i = 0; i < array.length; i++) {
			value += Integer.valueOf(array[i]).toString() + ", ";
		}
		value = "["+value+"]";
		value = value.replace(", ]", "]");
		System.out.println(value);
	}
	
	static int hourglassSum(int[][] arr) {

        boolean flagFirstTime = false;
        
        int maxValue = -32768;
        
        for(int i = 0; i < 4; i ++) {
            
            for(int j = 0; j < 4; j++) {
                
            	System.out.println("Punto: (" + i + "," + j + ")");
            	
                int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] 
                    + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1]
                        + arr[i+2][j+2];
        
                System.out.println("suma: " + sum);
                
                if(flagFirstTime) {
                    maxValue = sum;
                }else if(sum > maxValue) {
                    maxValue = sum;
                }
                
            }
        }
        
        int[][] matrix = new int[2][3];
        
        matrix[0][0] = 0;
        matrix[0][1] = 0;
        matrix[0][2] = 0;
        
        matrix[1][0] = 0;
        matrix[1][1] = 0;
        matrix[1][2] = 0;
        
        
        System.out.println("row size: " + matrix.length);
        System.out.println("column size: " + matrix[0].length);
        
        return maxValue;

    }

	
    static long repeatedString(String s, long n) {

    	Long repetitions;
    	
    	//Evaluamos si n es menor que el size de la palabra
    	int wordSize = s.length();
    	
    	if(n <= wordSize) {
    		repetitions = Long.valueOf(aQtys(s.substring(0, Long.valueOf(n).intValue())));
    	}else {
    		repetitions = calculateAsInLongerWord(s, n);
    	}
    	
    	return repetitions;
    }

    static long calculateAsInLongerWord(String s, Long n) {
    	    	
    	Long wordSize = Long.valueOf(s.length());
    	
    	Long division = Long.divideUnsigned(n, wordSize);
    	
    	Long diff = n - (division * wordSize);
    	
    	int aQtyInWord = aQtys(s);
    	
    	Long aQtyInInfinitiWord = aQtyInWord * division;
    	
    	int aQtyInRestWords = aQtys(s.substring(0, diff.intValue()));
    	
    	return aQtyInInfinitiWord + aQtyInRestWords;
    	
    }
    
    static int aQtys(String word) {
    	int qty = 0;
    	
    	for(int i = 0; i < word.length(); i ++) {
    		if(word.charAt(i) == 'a') {
    			qty += 1;
    		}
    	}
    	
    	return qty;
    }
    
    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {

    	int size = a.length;
    	
    	int[] rotatedArray = new int[size];
    	
    	//Preguntamos si estamos rotando de forma tal que el array quedaria igual
    	if(d == 0 || ((size - d) == 0)) {
    		rotatedArray = a;
    	}else if(d != 0){

    		int rotationValue = d;
    		
    		if(d >= size) {
    			rotationValue = d - size;
    		}
    		
    		//Si estamos rotando:
    		for(int i = 0; i < size; i ++) {
    			
    			int position = i + rotationValue;
    			
    			if(position >= size) {
    				position = position % size;
    			}
    			
    			rotatedArray[i] = a[position];
    		}
    	}
    	
    	System.out.println("array rotado " + d + "veces: " + d);
    	imprimirArray(rotatedArray);
    	
    	return rotatedArray;
    			

    }
    
    
    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
    	
    	if(!anyGetMoreThanTwoStepsSwap(q)) {
    		
    		int brives = countBrives(q);
    		
    		System.out.println("Cantidad de saltos: " + brives);
    		
    	}else {
    		System.out.println("Too chaotic");
    	}
    	
    }
    
    static int countBrives(int[] q) {
    	
    	int qtyBrives = 0;
    	
    	//Asumimos que el array va a estar desordenado
    	boolean arrayInOrder = false;
    	
    	//Mientras el array est� desornedado, iteramos
    	while(!arrayInOrder) {
    		
    		int iterator = 0;
    		
			//Asumo que el array no recibir� cambios.
			boolean changesMade = false;
    		
    		while(iterator < q.length) {
    			
    			int personValue = q[iterator];
    			
    			//Si un valor del array no est� en orden, implica que si o si se har� 
    			//alg�n cambio
    			if(!isInTheCorrectPosition(personValue, iterator)) {
    				
    				changesMade = true;
    				
    				int nextPersonValue = q[iterator + 1];
    				
    				//Si el valor siguiente, es menor que el actual, est� bien hacer el swap.
    				//Si es mayor, lo dejo donde est�. Al avanzar el iterator, evaluar� si a 
    				//ese valor lo corro a su vez mas adelante.
    				if(nextPersonValue < personValue) {
    					q[iterator] = nextPersonValue;
    					q[iterator + 1] = personValue;
    					
    					qtyBrives += 1;
    				}
    			}
    			
    			iterator += 1;
    		}
    		
    		//Si no hubo cambios en el array significa que est� ordenado.
    		if(!changesMade) {
    			arrayInOrder = true;
    		}
    	}
    	
    	System.out.println("Array ordenado: \r\n ");
    	imprimirArray(q);
    	
    	return qtyBrives;
    	
    }
    
    static boolean isInTheCorrectPosition(int personValue, int positionValue) {
    	return (personValue - 1) == positionValue;
    }
    
    static boolean anyGetMoreThanTwoStepsSwap(int[] array) {
    	
    	boolean find = false;
    	
    	for(int i = 0; i < array.length && !find; i++) {
    		
    		int personValue = array[i];    		
			int result = personValue - (i + 1);
    		
			if(result > 2) find = true;
    			    		
    	}
    	
    	return find;
    }
    
    
    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {

    	int qty = 0;
    	
    	int movementsToGroup = 0;
    	
    	int half = arr.length;
    	
    	//Movemos los n�meros y los pasamos a la mitad que conviene.
    	for(int i = 0; i < arr.length; i ++) {
    		
    		int actualValue = arr[i];
    		
    		if(!belongToThisHalf(actualValue, i, half)) {
    			
    			movementsToGroup += 1;
    			
    			int positionOfOtherGroup = getPositionOfMinorValueOfTheOtherGroup(arr, i, half);
    			
    			
    		}
    	}
    	
    	//Ordenamos por posiciones
    	for(int i = 0; i < arr.length; i++) {
    		int actualValue = arr[i];
    	}
    	
    	return qty;

    }
    
    static int getPositionOfMinorValueOfTheOtherGroup(int[] array, int pointerPosition, int halfValue) {
    	
    	//Asumimos que el menor 
    	int positionOfMinorValue = halfValue;
    	int minorValue = array[halfValue];
    	
    	for(int i = halfValue + 1; i < array.length; i++) {
    		
    		int value = array[i];
    		
    		if(value < minorValue && (value >= pointerPosition + 1)) {
    			positionOfMinorValue = i;
    			minorValue = value;
    		}
    	}
    	
    	return positionOfMinorValue;
    }
    
    static boolean belongToThisHalf(int actualValue, int arrayPosition, int halfValue) {
    	return (actualValue <= halfValue) && (arrayPosition < halfValue);
    }
}
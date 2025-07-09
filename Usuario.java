import java.util.Arrays;
import java.util.Scanner;

public class Usuario extends Thread {

    private int[] vetor;

    public Usuario (int[] vetor){

        this.vetor = vetor;
    }

    @Override
    public void run(){

        System.out.println("Lista não sequenciada");
        for (int idx = 0; idx < vetor.length; idx++) {
            Object elem = vetor[idx];
            System.out.println(elem);
        
        }

        System.out.println("Lista 3sequenciada");
        for (int idx = 0; idx < vetor.length; idx++) {
            
            Arrays.sort(vetor);
            Object elem = vetor[idx];
            System.out.println(elem);
        }

    }
}

class Programa{

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite quanto números quer inserir: ");

        int tamanho_vetor = scanner.nextInt();
        System.out.print("\n");


        int array[] = new int[tamanho_vetor];

        for (int i = 0; i < tamanho_vetor; i++) {

            System.out.print("Digite os números que deseja inserir: ");
            int numero_inserir = scanner.nextInt();
            array[i] = numero_inserir;
        }

        Usuario threadA = new Usuario(array);

        threadA.start();

        System.out.println("FIM Main");
    }
}
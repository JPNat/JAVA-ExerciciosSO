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

        System.out.println("Lista sequenciada");
        for (int idx = 0; idx < vetor.length; idx++) {
            
            Arrays.sort(vetor);
            Object elem = vetor[idx];
            System.out.println(elem);
        }

    }
}

class Programa{

    public static void main(String[] args) {

        int opcao;

        do {
            
        
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
            try {
                threadA.join();
            } catch (InterruptedException e) {
                System.out.println("Thread foi interrompida.");
            }

            System.out.print("Deseja fazer novamente? 1 - Sim ou 0 - Sair: ");

            opcao = scanner.nextInt();


        } while (opcao != 0);

        System.out.println("FIM Main");
    }
}

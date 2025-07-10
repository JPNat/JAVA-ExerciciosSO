
import java.util.ArrayList;

// Uma thread vai querer ler ou escrever
// Se uma thead querer ler, permitir caso não tenha um thread de escrita antes
// Se uma thread quer escrever, bloquear todas as threads

// O que preciso fazer?

// Uma lista que tenha métodos que as threads só precisem usar esses métodos sem precisar se preocupar com problema de corrida


// Como faço isso noo JAVA?

// Posso criar uma classe ThreadSafeList que possua métodos próprio para inserir números em uma lista

// O que ela precisa ter?

// Método para ler a lista; Método para escrever uem uma lista;

public class  ThreadSafeList extends Thread{

    private ArrayList<Integer> list = new ArrayList<>();
    private boolean isEmptyLeitura = true;
    private boolean isEmptyEscrita = true;

    public ThreadSafeList (ArrayList<Integer> list){

        this.list = list;
    }

    
    public synchronized void lerArray (){

        // int tamanhoArray = list.size();

        while(!isEmptyLeitura){
            try {
                wait();
            } catch(InterruptedException e) {
                 System.out.println("got interrupted!");
            }
        }

        for (int i = 0; i < list.size(); i++) {
            
            System.out.println("Posicao " + i + "=" + list.get(i) + "\n");
            
        }
    }

    public synchronized void escreverArray(int posicao, int valor){

        while(!isEmptyEscrita){
            try {
                wait();
            } catch(InterruptedException e) {
                 System.out.println("got interrupted!");
            }
        }

        isEmptyEscrita = false;
        isEmptyLeitura = false;

        try {

            list.set(posicao, valor);
            System.out.println("Valor colocado");
            isEmptyEscrita = true;
            isEmptyLeitura = true;
            notifyAll();

        } catch (Exception e) {
            System.out.println("Deu ruim");
            isEmptyEscrita = true;
            isEmptyLeitura = true;
            notifyAll();

        }

    }
}


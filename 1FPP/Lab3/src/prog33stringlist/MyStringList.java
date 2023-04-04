package prog33stringlist;

import java.util.Arrays;

public class MyStringList {
    private final int INITIAL_LENGTH = 2;
    private String[] strArray;
    private int size;

    public MyStringList() {
        strArray = new String[INITIAL_LENGTH];
        size = 0;
    }

    public void add(String s){
        if(this.size >= strArray.length) this.resize();
        this.strArray[size] = s;
        size++;
    }

    public void remove(String s){
        if(this.size == 1){
            this.strArray = new String[0];
        }else{
            boolean removed = false;
            String[] aux = new String[this.size - 1];

            //finish this shit
            for(int index = 0; index < aux.length; index++){
                if(!this.strArray[index].equalsIgnoreCase(s) && !removed){
                    aux[index] = this.strArray[index];
                    size--;
                };
            }

            this.strArray = aux;
        }
    }

    public void removeAll(String s){
        if(this.size == 1){
            this.strArray = new String[0];
            return;
        }

        int count = 0;

        for(String item : this.strArray){
            if(item != null && item.equalsIgnoreCase(s)) count++;
        }

        if(this.size - count == 0) {
            this.strArray = new String[0];
            return;
        }

        String[] aux = new String[this.size - count];

        int controlIndex = 0;

        for(String item : this.strArray){
            if(item != null && !item.equalsIgnoreCase(s)){
                aux[controlIndex] = item;
                controlIndex++;
            }
        }

        this.strArray = aux;

        this.size -= count;
    }

    public String get(int index){
        return this.strArray[index];
    }

    public boolean find(String s){
       for(String item : this.strArray){
           if(s.equals(item)) return true;
       }
       return false;
    }

    public void insert(String s, int pos){
        if(this.size >= this.strArray.length) this.resize();

        for(int index = this.size; index >= 0;  index--) {
            if(index == pos){
                this.strArray[index] = s;
                size++;
                break;
            }

            this.strArray[index] = this.strArray[index - 1];
        }
    }

    public int size(){
        return this.size;
    }

    public String toString(){
        String[] aux = new String[this.size];

        System.arraycopy(this.strArray, 0, aux, 0, this.size);

        return Arrays.toString(aux);
    }

    private void resize(){
        System.out.println("Resizing...");
        String[] aux = new String[this.strArray.length * 2];

        System.arraycopy(this.strArray, 0, aux, 0, this.strArray.length);

        this.strArray = aux;
    }

    public void sort(){
        String[] arr = this.strArray;
        for(int index = 0; index < this.size; index++){
            for(int secondIndex = index; secondIndex < this.size; secondIndex++){
                if(arr[index].compareTo(arr[secondIndex]) > 0){
                    String aux = arr[index];
                    arr[index] = arr[secondIndex];
                    arr[secondIndex] = aux;
                }
            }
        }
    }
}

package prog33stringlist;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyStringList {
    public int size = 0;
    private String[] strArray = new String[50];

    public void add(String s){
        if(this.size >= 50) this.resize();
        this.strArray[size] = s;
        size++;
    }

    public void remove(String s){
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

    public int size(){
        return this.size;
    }

    public String toString(){
        String[] aux = new String[this.size];

        System.arraycopy(this.strArray, 0, aux, 0, this.size);

        return Arrays.toString(aux);
    }

    private void resize(){
        String[] aux = new String[this.strArray.length * 2];

         System.arraycopy(this.strArray, 0, aux, 0, this.strArray.length);

         this.strArray = aux;
    }
}

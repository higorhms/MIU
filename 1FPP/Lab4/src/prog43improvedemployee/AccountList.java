package prog43improvedemployee;

import java.util.Arrays;

public class AccountList {
    private final int INITIAL_LENGTH = 2;
    private Account[] strArray;
    private int size;

    public AccountList() {
        strArray = new Account[INITIAL_LENGTH];
        size = 0;
    }

    public void add(Account s){
        if(this.size >= strArray.length) this.resize();
        this.strArray[size] = s;
        size++;
    }

    public void remove(Account s){
        if(this.size == 1){
            this.strArray = new Account[0];
            return;
        }

        int count = 0;

        for(Account item : this.strArray){
            if(item != null && item.equals(s)) count++;
        }

        if(this.size - count == 0) {
            this.strArray = new Account[0];
            return;
        }

        Account[] aux = new Account[this.size - count];

        int controlIndex = 0;

        for(Account item : this.strArray){
            if(item != null && !item.equals(s)){
                aux[controlIndex] = item;
                controlIndex++;
            }
        }

        this.strArray = aux;

        this.size -= count;
    }

    public Account get(int index){
        return this.strArray[index];
    }

    public boolean find(String s){
       for(Account item : this.strArray){
           if(s.equals(item)) return true;
       }
       return false;
    }

    public void insert(Account s, int pos){
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
        Account[] aux = new Account[this.strArray.length * 2];

        System.arraycopy(this.strArray, 0, aux, 0, this.strArray.length);

        this.strArray = aux;
    }
}

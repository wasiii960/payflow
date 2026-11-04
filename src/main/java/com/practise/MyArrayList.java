package com.practise;

public class MyArrayList {
    int size=2;
    int currentSize=0;
    int [] arr = new int[size];
    public void add(int num){
        if(currentSize<size){
            arr[currentSize]=num;
            currentSize++;
        }else{
            grow();
            arr[currentSize++]=num;
        }
    }
    public int get(int index){
        if(currentSize==0 || index>currentSize) throw new IndexOutOfBoundsException();
        else return arr[index];
    }
    private void grow() {
        size*=2;
        int [] newArr= new int[size];
        for(int i=0;i<arr.length;i++){
            newArr[i]=arr[i];
        }
        arr = newArr;
    }
    public int size(){
        return currentSize;
    }
    public int remove(int index){
        if (currentSize==0 || index>currentSize) throw new IndexOutOfBoundsException();
        int deleted=arr[index];
        if(index!=currentSize){
            for(int i=index+1;i<currentSize;i++){
                int temp=arr[index];
                arr[index]=arr[i];
                arr[i]=temp;
                index++;
            }
        }
        currentSize--;
        return deleted;
    }
}

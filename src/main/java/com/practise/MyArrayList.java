package com.practise;

public class MyArrayList {
    private int size=0;
    private int [] arr = new int[2];
    public void add(int num){
        if(size<arr.length){
            arr[size]=num;
            size++;
        }else{
            grow();
            arr[size++]=num;
        }
    }
    public int get(int index){
        if(index<0 || index>=size) throw new IndexOutOfBoundsException("Index you are trying to get does not exist.Index:"+index+" Size:"+size);
        else return arr[index];
    }
    private void grow() {
        int tempSize=arr.length*2;
        int [] newArr= new int[tempSize];
        for(int i=0;i<arr.length;i++){
            newArr[i]=arr[i];
        }
        arr = newArr;
    }
    public int size(){
        return size;
    }
    public int remove(int index){
        if (index<0 || index>=size) throw new IndexOutOfBoundsException("Index you are trying to delete does not exist.Index:"+index+" Size:"+size);
        int deleted=arr[index];
        for(int i=index+1;i<size;i++){
            int temp=arr[index];
            arr[index]=arr[i];
            arr[i]=temp;
            index++;
        }
        size--;
        return deleted;
    }
}

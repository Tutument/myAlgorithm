package com.example.myalgorithm.day2;

public class Array_To_Stack_Queue {

    public static class ArrayStack {
        private Integer[] arr;
        private Integer size;

        public ArrayStack(Integer initSize) {
            arr = new Integer[initSize];
            size = 0;
        }

        public void push(int obj) {
            if (size == arr.length) {
                throw new IndexOutOfBoundsException("栈溢出异常");
            }
            arr[size++] = obj;
        }

        public Integer pop() {
            if (size == 0) {
                throw new IndexOutOfBoundsException("栈为空异常");
            }
            return arr[--size];
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[size - 1];
        }
    }

    public static class ArrayQueue {
        private int start;
        private int end;
        private int size;
        private int[] arr;

        public ArrayQueue(int initSize) {
            arr = new int[initSize];
            start = 0;
            end = 0;
            size = 0;
        }

        public void push(int obj) {
            if (size == arr.length) {
                throw new IndexOutOfBoundsException("队列已满");
            }
            size++;
            arr[end] = obj;
            end = end == arr.length - 1 ? 0 : end + 1;
        }

        public int poll() {
            if (size == 0) {
                throw new IndexOutOfBoundsException("队列为空");
            }
            size--;
            int tmp = start;
            start = start == arr.length - 1 ? 0 : start + 1;
            return arr[tmp];
        }


    }
}

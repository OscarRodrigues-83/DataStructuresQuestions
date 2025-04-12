public int lastIndexOf(int valor) {
        if(this.head == -1) return -1;

        int index = -1;
        for (int i = head; i <= this.tail; i = (i + 1) % this.arrayFila.length) {
            if(this.arrayFila[i] == valor ) index = i;
        }

        return index;

    }

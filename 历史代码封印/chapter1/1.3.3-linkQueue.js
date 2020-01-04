class Node {
    constructor() {
        this.item = null;
        this.next = null;
    }
}

class LinkedQueue {
    constructor() {
        this.N = 0;
        this.first = null;
        this.last = null;
    }

    enqueue(item) {
        let oldLast = this.last;
        let newLastNode = new Node();
        newLastNode.item = item;
        
        this.last = newLastNode;
        if(this.isEmpty()) {
            this.first = this.last;
        }else {
            oldLast.next = this.last;
        }
        this.N++;
    }
    dequeue() {
        if(!this.first) {
            return null;
        }

        let item = this.first.item;
        this.first = this.first.next;
        this.N--;
        return item;
    }
    isEmpty() {
        return this.first === null;
    }
    size() {
        return this.N;
    }
}


let test = new LinkedQueue();
test.enqueue(1);
test.enqueue(2);
console.log(test.isEmpty());
console.log(test.size());
console.log(test.dequeue());
console.log(test.size());
console.log(test.isEmpty());
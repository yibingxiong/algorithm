class Node {
    constructor() {
        this.item = null;
        this.next = null;
    }
}

class LinkedStack {
    constructor() {
        this.N = 0;
        this.first = null;
    }

    push(item) {
        let oldFirst = this.first;
        this.first = new Node();
        this.first.item = item;
        this.first.next = oldFirst;
        this.N++;
    }
    pop() {
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


let test = new LinkedStack();
test.push(1);
test.push(2);
console.log(test.isEmpty());
console.log(test.size());
console.log(test.pop());
console.log(test.size());
console.log(test.isEmpty());
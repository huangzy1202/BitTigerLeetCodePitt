// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> peekIterator;
    Integer next = null;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    peekIterator = iterator;
        next = peekIterator.next(); 
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer result = next;
        if (peekIterator.hasNext()) {
            next = peekIterator.next();
        } else {
            next = null;
        }
        return result; 
	}

	@Override
	public boolean hasNext() {
	   return next != null;
	}
}

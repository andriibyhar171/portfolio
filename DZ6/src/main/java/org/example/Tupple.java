package org.example;

public class Tupple<A,B> {

    public static <P, Q> Tupple<P, Q> makeTupple(P p, Q q) {
        return new Tupple<P, Q>(p, q);
    }

    public final A a;
    public final B b;

    public Tupple(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((a == null) ? 0 : a.hashCode());
        result = prime * result + ((b == null) ? 0 : b.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        @SuppressWarnings("rawtypes")
        Tupple other = (Tupple) obj;
        if (a == null) {
            if (other.a != null) {
                return false;
            }
        } else if (!a.equals(other.a)) {
            return false;
        }
        if (b == null) {
            if (other.b != null) {
                return false;
            }
        } else if (!b.equals(other.b)) {
            return false;
        }
        return true;
    }

    public boolean isInstance(Class<?> classA, Class<?> classB) {
        return classA.isInstance(a) && classB.isInstance(b);
    }

    @SuppressWarnings("unchecked")
    public static <P, Q> Tupple<P, Q> cast(Tupple<?, ?> pair, Class<P> pClass, Class<Q> qClass) {

        if (pair.isInstance(pClass, qClass)) {
            return (Tupple<P, Q>) pair;
        }

        throw new ClassCastException();

    }
    public static void main(String[] args){
        makeTupple (1,2);
    }
}
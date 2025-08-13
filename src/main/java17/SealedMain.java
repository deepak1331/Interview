package org.example.java17;

sealed class X permits M, Y, Z {
}

//Sealed can be extended by sealed/ non-sealed or final class only
//Sealed class & Interface  must have subclasses
sealed class Y extends X permits Sub {
}

non-sealed class Z extends X {
}

final class M extends X {
}

final class Sub extends Y {
}

sealed interface I permits J, K {
}

non-sealed interface J extends I {
}

sealed interface K extends I {
}

final class KSub implements K {
}


public class SealedMain {

    public static void main(String[] args) {
        Z obj = new Z();
    }
}

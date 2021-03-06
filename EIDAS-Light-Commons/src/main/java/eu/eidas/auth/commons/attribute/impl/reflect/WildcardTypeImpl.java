/**
 *
 */
package eu.eidas.auth.commons.attribute.impl.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

final class WildcardTypeImpl implements WildcardType {

    private final Type[] upperBounds;

    private final Type[] lowerBounds;

    public WildcardTypeImpl(Type[] upperBounds, Type[] lowerBounds) {
        if (upperBounds.length == 0) {
            throw new IllegalArgumentException(
                    "There must be at least one upper bound. For an unbound wildcard, the upper bound must be Object");
        }
        this.upperBounds = upperBounds;
        this.lowerBounds = lowerBounds;
    }

    public Type[] getUpperBounds() {
        return upperBounds.clone();
    }

    public Type[] getLowerBounds() {
        return lowerBounds.clone();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof WildcardType)) {
            return false;
        }
        WildcardType other = (WildcardType) obj;
        return Arrays.equals(lowerBounds, other.getLowerBounds()) && Arrays.equals(upperBounds, other.getUpperBounds());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(lowerBounds) ^ Arrays.hashCode(upperBounds);
    }

    @Override
    public String toString() {
        if (lowerBounds.length > 0) {
            return "? super " + GenericTypeReflector.getTypeName(lowerBounds[0]);
        } else if (upperBounds[0] == Object.class) {
            return "?";
        } else {
            return "? extends " + GenericTypeReflector.getTypeName(upperBounds[0]);
        }
    }
}
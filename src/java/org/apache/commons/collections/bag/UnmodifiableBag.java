/*
 *  Copyright 2003-2004 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.commons.collections.bag;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections.Bag;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.iterators.UnmodifiableIterator;
import org.apache.commons.collections.set.UnmodifiableSet;

/**
 * Decorates another <code>Bag</code> to ensure it can't be altered.
 *
 * @since Commons Collections 3.0
 * @version $Revision: 1.6 $ $Date: 2004/02/18 00:56:25 $
 * 
 * @author Stephen Colebourne
 */
public final class UnmodifiableBag
        extends AbstractBagDecorator implements Unmodifiable {

    /**
     * Factory method to create an unmodifiable bag.
     * 
     * @param bag  the bag to decorate, must not be null
     * @throws IllegalArgumentException if bag is null
     */
    public static Bag decorate(Bag bag) {
        if (bag instanceof Unmodifiable) {
            return bag;
        }
        return new UnmodifiableBag(bag);
    }

    //-----------------------------------------------------------------------
    /**
     * Constructor that wraps (not copies).
     * 
     * @param bag  the bag to decorate, must not be null
     * @throws IllegalArgumentException if bag is null
     */
    private UnmodifiableBag(Bag bag) {
        super(bag);
    }

    //-----------------------------------------------------------------------
    public Iterator iterator() {
        return UnmodifiableIterator.decorate(getCollection().iterator());
    }

    public boolean add(Object object) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection coll) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object object) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection coll) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection coll) {
        throw new UnsupportedOperationException();
    }

    //-----------------------------------------------------------------------
    public boolean add(Object object, int count) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object object, int count) {
        throw new UnsupportedOperationException();
    }

    public Set uniqueSet() {
        Set set = getBag().uniqueSet();
        return UnmodifiableSet.decorate(set);
    }

}

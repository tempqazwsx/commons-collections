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

import java.util.Set;

import org.apache.commons.collections.Bag;
import org.apache.commons.collections.collection.SynchronizedCollection;
import org.apache.commons.collections.set.SynchronizedSet;

/**
 * Decorates another <code>Bag</code> to synchronize its behaviour
 * for a multi-threaded environment.
 * <p>
 * Methods are synchronized, then forwarded to the decorated bag.
 * Iterators must be separately synchronized around the loop.
 *
 * @since Commons Collections 3.0
 * @version $Revision: 1.5 $ $Date: 2004/02/18 00:56:25 $
 * 
 * @author Stephen Colebourne
 */
public class SynchronizedBag
        extends SynchronizedCollection implements Bag {

    /**
     * Factory method to create a synchronized bag.
     * 
     * @param bag  the bag to decorate, must not be null
     * @throws IllegalArgumentException if bag is null
     */
    public static Bag decorate(Bag bag) {
        return new SynchronizedBag(bag);
    }
    
    //-----------------------------------------------------------------------
    /**
     * Constructor that wraps (not copies).
     * 
     * @param bag  the bag to decorate, must not be null
     * @throws IllegalArgumentException if bag is null
     */
    protected SynchronizedBag(Bag bag) {
        super(bag);
    }

    /**
     * Constructor that wraps (not copies).
     * 
     * @param bag  the bag to decorate, must not be null
     * @param lock  the lock to use, must not be null
     * @throws IllegalArgumentException if bag is null
     */
    protected SynchronizedBag(Bag bag, Object lock) {
        super(bag, lock);
    }

    protected Bag getBag() {
        return (Bag) collection;
    }
    
    //-----------------------------------------------------------------------
    public boolean add(Object object, int count) {
        synchronized (lock) {
            return getBag().add(object, count);
        }
    }

    public boolean remove(Object object, int count) {
        synchronized (lock) {
            return getBag().remove(object, count);
        }
    }

    public Set uniqueSet() {
        synchronized (lock) {
            Set set = getBag().uniqueSet();
            return new SynchronizedBagSet(set, lock);
        }
    }

    public int getCount(Object object) {
        synchronized (lock) {
            return getBag().getCount(object);
        }
    }
    
    //-----------------------------------------------------------------------
    /**
     * Synchronized Set for the Bag class.
     */
    class SynchronizedBagSet extends SynchronizedSet {
        SynchronizedBagSet(Set set, Object lock) {
            super(set, lock);
        }
    }

}

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

import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.collections.SortedBag;

/**
 * Decorates another <code>SortedBag</code> to validate that elements added
 * are of a specific type.
 * <p>
 * The validation of additions is performed via an instanceof test against 
 * a specified <code>Class</code>. If an object cannot be added to the
 * collection, an IllegalArgumentException is thrown.
 *
 * @since Commons Collections 3.0
 * @version $Revision: 1.4 $ $Date: 2004/02/18 00:56:25 $
 * 
 * @author Stephen Colebourne
 * @author Matthew Hawthorne
 */
public class TypedSortedBag {

    /**
     * Factory method to create a typed sorted bag.
     * <p>
     * If there are any elements already in the bag being decorated, they
     * are validated.
     * 
     * @param bag  the bag to decorate, must not be null
     * @param type  the type to allow into the bag, must not be null
     * @throws IllegalArgumentException if bag or type is null
     * @throws IllegalArgumentException if the bag contains invalid elements
     */
    public static SortedBag decorate(SortedBag bag, Class type) {
        return new PredicatedSortedBag(bag, PredicateUtils.instanceofPredicate(type));
    }

    /**
     * Restrictive constructor.
     */
    protected TypedSortedBag() {
    }

}

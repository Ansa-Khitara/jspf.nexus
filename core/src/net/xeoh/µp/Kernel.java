/*
 * Kernel.java
 * 
 * Copyright (c) 2011, Ralf Biedert, DFKI. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 * 
 * Redistributions of source code must retain the above copyright notice, this list of
 * conditions and the following disclaimer. Redistributions in binary form must reproduce the
 * above copyright notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * 
 * Neither the name of the author nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS
 * OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
 * TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 */
package net.xeoh.µp;

import java.util.Collection;

import net.xeoh.µp.options.GetAll;

/**
 * A kernel manages various services and provides implementations for
 * interfaces. 
 * 
 * @author Ralf Biedert
 * @since 1.0
 */
public interface Kernel {
    /** Options for get() */
    public static abstract class Get {
        public static final GetAll ALL = new GetAll();
    }

    /**
     * Registers the collection of {@link Service} objects to this kernel. When this method 
     * returns they can be aquired with the <code>get()</code> method.
     *  
     * @since 1.0
     * @param service The services to register.
     * @return This kernel again.
     */
    public Kernel register(Collection<? extends Service> service);

    /**
     * Deregisters {@link Service} objects from this kernel. When the method returns,
     * the services are not available anymore. 
     * 
     * @since 1.0
     * @param service The services to deregister.
     * @return This kernel again.
     */
    public Kernel deregister(Collection<? extends Service> service);

    /**
     * Returns an implementor for a given class. If you pass an interface the next best
     * service matching the class will be returned. If you pass an ordinary class, the next 
     * best instance of this class is being returned.
     * 
     * @since 1.0
     * @param service The service to get.
     * @param options A number of optional arguments to specify what exactly you want.
     * @return The requested object or null if nothing suitable was found.
     */
    public <T> T get(Class<T> service, Get... options);

    
    /**
     * Lists all known services.  
     * 
     * @since 1.0
     * @return Returns a collection with all known services.
     */
    public Collection<Service> list();
}

/**
 *
 * Copyright (C) 2009 Cloud Conscious, LLC. <info@cloudconscious.com>
 *
 * ====================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ====================================================================
 */
package org.jclouds.blobstore;

import java.util.List;
import java.util.Properties;

import org.jclouds.blobstore.config.TransientBlobStoreContextModule;
import org.jclouds.blobstore.config.TransientBlobStoreModule;

import com.google.inject.Module;
import com.google.inject.TypeLiteral;

/**
 * @author Adrian Cole
 */
public class TransientBlobStoreContextBuilder extends
         BlobStoreContextBuilder<AsyncBlobStore, BlobStore> {

   /**
    * This is only to have the same syntax.
    * 
    */
   public TransientBlobStoreContextBuilder(String providerName, Properties props) {
      this();
   }

   public TransientBlobStoreContextBuilder() {
      super("transient", new TypeLiteral<AsyncBlobStore>() {
      }, new TypeLiteral<BlobStore>() {
      });
   }

   @Override
   public void addContextModule(String providerName, List<Module> modules) {
      modules.add(new TransientBlobStoreContextModule());
   }

   @Override
   protected void addClientModule(List<Module> modules) {
      modules.add(new TransientBlobStoreModule());
   }

}
package com.example.patterns.simpleFactory;

import com.example.patterns.simpleFactory.entity.BlogPost;
import com.example.patterns.simpleFactory.entity.NewsPost;
import com.example.patterns.simpleFactory.entity.Post;
import com.example.patterns.simpleFactory.entity.ProductPost;

/**
 * This class acts as a simple factory for creation of 
 * different posts on web site.
 *
 */
public class PostFactory {
   public static Post createInstance(final String type)
   {
      switch (type)
      {
         case "blog" : return new BlogPost();
         case "news" : return new NewsPost();
         case "product" : return new ProductPost();
         default : throw new IllegalArgumentException("Unknown product type");
      }
   }
}

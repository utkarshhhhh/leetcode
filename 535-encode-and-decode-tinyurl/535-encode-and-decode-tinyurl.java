public class Codec {

    HashMap<Integer,String> map = new HashMap<>();
    String host = "http://tinyurl.com/" ; 
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        
        int hashcode = longUrl.hashCode(); 
        map.put( hashcode , longUrl );
        return host+hashcode;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        
      int key = (int)Integer.parseInt(shortUrl.replace(host,""));
        return map.get(key);    
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
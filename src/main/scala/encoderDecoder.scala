object encoderDecoder {
  def main(args: Array[String]): Unit = {
    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ "

    val E=(c:Char,key:Int,a:String)=> a((a.indexOf(c.toUpper)+key)%a.size)

    val D=(c:Char,key:Int,a:String)=> a(if((a.indexOf(c.toUpper)-key)%a.size >=0) (a.indexOf(c.toUpper)-key)%a.size else a.size+(a.indexOf(c.toUpper)-key)%a.size)

    val cipher=(algo:(Char,Int,String)=> Char,s:String,key:Int,a:String)=> s.map(algo(_,key,a))

    val s = "We are planning to attack tomorrow at five evening"
    val ct=cipher(E, s ,5 ,alphabet)
    val pt=cipher(D,ct,5,alphabet)

    println("TEXT: " + s)
    println("ENCRYPTED: " + ct)
    println("DECRYPTED:" + pt)
  }
}

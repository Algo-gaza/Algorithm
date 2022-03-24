import Foundation

func solution(_ w:Int, _ h:Int) -> Int64{
    let gcdValue = gcd(w,h)
    
    return  (w == 1 && h == 1) ? Int64(0) : Int64(w*h-(w+h)+gcdValue)
}

// 유클리드 호제법
func gcd(_ a: Int, _ b: Int) -> Int {
    let mod: Int = a%b
    return 0 == mod ? min(a,b) : gcd(b,mod)
}

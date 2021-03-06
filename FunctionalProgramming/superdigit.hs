-- solution to
-- https://www.hackerrank.com/challenges/super-digit


import Data.Char

super :: Int -> Int
super x |x < 10 = x
          |otherwise = super (sumDigits(x))
sumDigits :: Int -> Int 
sumDigits x = if x>0 then (mod x 10) + sumDigits (div x 10) else 0


makeSum :: String -> Int
makeSum [] = 0
makeSum (x:xs) | x == ' ' = 0
               |otherwise = (digitToInt x) + makeSum xs

superFF :: String -> Int -> Int
superFF x y = super ((makeSum x) * y)

separate :: String -> Int
separate xs = read (dropWhile (\x->x/=' ') xs) :: Int

main = do
 line <- getLine
 putStrLn (show (superFF line (separate line)))

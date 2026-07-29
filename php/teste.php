<?php

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function searchInsert($nums, $target) {
        $ini = 0;
        $fim = count($nums) -1;

        while($fim >= $ini){
            $meio = (int) (($fim + $ini)/2);
            echo "ini " . $ini . "\n";
            echo "meio " . $meio . "\n";
            echo "fim " . $fim . "\n";
            if($fim - $ini <=1){
                if($target < $nums[$meio]){
                    return $meio-1;
                }else if($target > $nums[$meio]){
                    return $meio+1;
                }
            }

            if($nums[$meio] == $target){
                return $meio;
            }else if($target < $nums[$meio]){
                $fim = $meio;
            }else if($target > $nums[$meio]){
                $ini = $meio;
            }

        }
        return -1;
    }
    /**
     * @param String $a
     * @param String $b
     * @return String
     */
function addBinary($a, $b) {
        $soma = bcadd($a, $b);
        print $soma . "\n";
        for($i = strlen($soma)-1 ; $i >= 0; $i--){
            if($i == 0 && ( (int) $soma[$i] ) > 1){
                $soma[$i] = bcdiv($soma[$i], "3");
                $soma =  "1" . $soma;
            }else if( ( (int) $soma[$i] ) > 1){
                $soma[$i-1] = bcadd($soma[$i-1], "1");
                $soma[$i] = bcdiv($soma[$i], "3");
            }
        }
        return $soma;
    }

print addBinary("11", "1");
print "\n";
print "\n";
print addBinary("1010", "1011");

$vet = [1,3,5,6];
//print searchInsert($vet, 7);


package kr.somoon.somoonshop.function.util;

public class ClothesSize {

// 주목! http://www.iycian.com/files/attach/images/150/976/076/size_02.jpg 참조바람

    public int Size(double Weight, double Height) {

        int SizeofClothes = 0;

        // 56 kg
        if (Weight <= 56) {
            if (Height <= 160) {
                SizeofClothes = 90;
            } else if (Height <= 170 && Height > 160) {
                SizeofClothes = 95;
            } else if (Height > 170) {
                SizeofClothes = 100;
            }

            // 58kg
        } else if (Weight <= 58 && Weight > 56) {
            if (Height <= 158) {
                SizeofClothes = 90;
            } else if (Height <= 170 && Height > 158) {
                SizeofClothes = 95;
            } else if (Height > 170) {
                SizeofClothes = 100;
            }

            // 60kg
        } else if (Weight <= 60 && Weight > 58) {
            if (Height <= 170) {
                SizeofClothes = 95;
            } else if (Height <= 178 && Height > 170) {
                SizeofClothes = 100;
            } else if (Height > 178) {
                SizeofClothes = 105;
            }

            // 62kg
        } else if (Weight <= 62 && Weight > 60) {
            if (Height <= 168) {
                SizeofClothes = 95;
            } else if (Height <= 176 && Height > 168) {
                SizeofClothes = 100;
            } else if (Height > 176) {
                SizeofClothes = 105;
            }

            // 64kg, 66kg
        } else if (Weight <= 66 && Weight > 62) {
            if (Height <= 166) {
                SizeofClothes = 95;
            } else if (Height <= 176 && Height > 166) {
                SizeofClothes = 100;
            } else if (Height > 176) {
                SizeofClothes = 105;
            }

            // 68kg
        } else if (Weight <= 68 && Weight > 66) {
            if (Height <= 162) {
                SizeofClothes = 100;
            } else if (Height <= 166 && Height > 162) {
                SizeofClothes = 95;
            } else if (Height <= 176 && Height > 166) {
                SizeofClothes = 100;
            } else if (Height > 176) {
                SizeofClothes = 105;
            }

            // 70kg
        } else if (Weight <= 70 && Weight > 68) {
            if (Height <= 162) {
                SizeofClothes = 100;
            } else if (Height <= 164 && Height > 162) {
                SizeofClothes = 95;
            } else if (Height <= 176 && Height > 164) {
                SizeofClothes = 100;
            } else if (Height > 176) {
                SizeofClothes = 105;
            }

            // 72kg, 74kg
        } else if (Weight <= 74 && Weight > 70) {
            if (Height <= 176) {
                SizeofClothes = 100;
            } else if (Height > 176) {
                SizeofClothes = 105;
            }

            // 76kg
        } else if (Weight <= 76 && Weight > 74) {
            if (Height <= 170) {
                SizeofClothes = 100;
            } else if (Height > 170) {
                SizeofClothes = 105;
            }

            // 78kg
        } else if (Weight <= 78 && Weight > 76) {
            if (Height <= 180) {
                SizeofClothes = 105;
            } else if (Height > 180) {
                SizeofClothes = 110;
            }

            // 80kg
        } else if (Weight <= 80 && Weight > 78) {
            if (Height <= 176) {
                SizeofClothes = 105;
            } else if (Height > 176) {
                SizeofClothes = 110;
            }

            // 82kg
        } else if (Weight > 80) {
            if (Height <= 174) {
                SizeofClothes = 105;
            } else if (Height > 174) {
                SizeofClothes = 110;
            }
        }

        return SizeofClothes;
    }

}

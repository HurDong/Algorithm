#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>

double n1, n2, n3;

void compare(double ab, double ac, double bc) {
	if (ab > ac) {
		if (ab > bc) {
			if (ac > bc) { n1 = ab; n2 = ac; n3 = bc; }//ab>ac>bc
			else { n1 = ab; n2 = bc; n3 = ac; }//ab>bc>ac
		}
		else {
			n1 = bc; n2 = ac; n3 = ac;//bc>ab>ac
		}
	}
	else {
		if (ab > bc) {
			n1 = ac; n2 = ab; n3 = bc;//ac>ab>bc
		}
		else {
			if (bc > ac) { n1 = bc; n2 = ac; n3 = ab; }//bc>ac>ab
			else { n1 = ac; n2 = bc; n3 = ab; }//ac>bc>ab
		}
	}
}

int main() {
	double xa, ya, xb, yb, xc, yc;
	double ab,ac,bc;
	scanf("%lf %lf %lf %lf %lf %lf", &xa, &ya, &xb, &yb, &xc, &yc);
	if ((xa - xb)*(ya - yc) == (xa - xc)*(ya - yb)) {
		printf("%.1lf", -1.0);
		return 0;
	}
	ab = sqrt(pow(fabs(xa - xb), 2) + pow(fabs(ya - yb), 2));
	ac = sqrt(pow(fabs(xa - xc), 2) + pow(fabs(ya - yc), 2));
	bc = sqrt(pow(fabs(xb - xc), 2) + pow(fabs(yb - yc), 2));
	compare(ab, ac, bc);
	printf("%.15lf", 2*(n1 - n3));
	return 0;
}
// %lf, %lf X %lf %lf O
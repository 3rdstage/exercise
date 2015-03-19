
#include <graphics.h>
#include <stdio.h>


int main(){

	Point p1;
	p1.x = 0;
	p1.y = 0;

	Point p2;
	p2.x = 1;
	p2.y = 1;

	Point p3;
	p3.x = 2;
	p3.y = 1;

	Point vertices[] = {p1, p2, p3}; // why not Point *vertices
	Path path1;
	path1.vertices = vertices;

	int len = (sizeof *(path1.vertices))/(sizeof (path1.vertices)[0]);

	printf("p1 is at (%d, %d)\n", p1.x, p1.y);
	printf("path1 links (%d, %d), (%d, %d), (%d, %d)\n",
			(path1.vertices)[0].x, (path1.vertices)[0].y,
			(path1.vertices)[1].x, (path1.vertices)[1].y,
			(path1.vertices)[2].x, (path1.vertices)[2].y);

	printf("length of path1 is : %d\n", len);

	Path *pt_path1;
	pt_path1 = &path1;

	Line *lines = getLinesOfPath(pt_path1);

	return 0;

}

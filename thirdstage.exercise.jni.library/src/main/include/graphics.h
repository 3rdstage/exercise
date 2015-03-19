
#define GRAPHICS_H_

#include "stdio.h"

#define PATH_VERTICE_MAX = 100;


typedef struct{
   int x;
   int y;
} Point;

typedef struct{
   Point start;
   Point end;
} Line;

typedef struct{
   Point *vertices;
} Path;

Line *getLinesOfPath(Path *path);



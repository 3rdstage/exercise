
#ifndef GRAPHICS_H_
#define GRAPHICS_H_

#ifdef BUILDING_GRAPHICS
#define EXPORT_OR_IMPORT __declspec(dllexport)
#else
#define EXPORT_OR_IMPORT __declspec(dllimport)
#endif // BUILDING_GRAPHIC

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

Line __stdcall EXPORT_OR_IMPORT *getLinesOfPath(Path *path);

#endif // GRAPHICS_H_



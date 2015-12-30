
#include <graphics.h>


Line *getLinesOfPath(Path *path){

        Point *vertices = path->vertices;
        int num_vertices = (sizeof *vertices)/(sizeof vertices[0]);

        Line *lines = new Line[num_vertices];

        for(int i = 0; i < num_vertices - 1; i++){
                (*(lines + i)).start = *(vertices + i);
                (*(lines + i)).end = *(vertices + i + 1);
        }

        return lines;
};

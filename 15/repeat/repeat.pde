size(500, 500);
background(#FFFCFC);

for (int i = 0; i<250; i += abs(-10)) {
  line(i, 0, i, 500);
}
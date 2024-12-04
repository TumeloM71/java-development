package com.pluralsight.model;

import java.time.Year;

public record Film (int filmId,String title,String description,int length,Year releaseYear){}

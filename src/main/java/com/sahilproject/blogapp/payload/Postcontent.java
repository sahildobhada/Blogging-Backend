package com.sahilproject.blogapp.payload;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Postcontent {
    private List<PostDTO> content;
    private int PageNumber;
    private int pagesize;
    private boolean lastpage;
}

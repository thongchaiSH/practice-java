package com.th.junit.domain.aml;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileBo {
    private String path;
    private String mimeType;
    private String size;
}

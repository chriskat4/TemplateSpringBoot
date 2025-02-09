package com.LOPKKD.LOPKKD.Handler;

import java.util.Map;
import java.util.Set;

public record ErrorResponse(
    Map<String, String> errors
) {

}

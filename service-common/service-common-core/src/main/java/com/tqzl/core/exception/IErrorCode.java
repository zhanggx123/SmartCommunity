
package com.tqzl.core.exception;

import java.io.Serializable;

public interface IErrorCode extends Serializable {

    String getResultCode();

    String getResultMessage();
}

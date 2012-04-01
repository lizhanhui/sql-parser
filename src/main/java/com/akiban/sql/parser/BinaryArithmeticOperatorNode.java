/**
 * END USER LICENSE AGREEMENT (“EULA”)
 *
 * READ THIS AGREEMENT CAREFULLY (date: 9/13/2011):
 * http://www.akiban.com/licensing/20110913
 *
 * BY INSTALLING OR USING ALL OR ANY PORTION OF THE SOFTWARE, YOU ARE ACCEPTING
 * ALL OF THE TERMS AND CONDITIONS OF THIS AGREEMENT. YOU AGREE THAT THIS
 * AGREEMENT IS ENFORCEABLE LIKE ANY WRITTEN AGREEMENT SIGNED BY YOU.
 *
 * IF YOU HAVE PAID A LICENSE FEE FOR USE OF THE SOFTWARE AND DO NOT AGREE TO
 * THESE TERMS, YOU MAY RETURN THE SOFTWARE FOR A FULL REFUND PROVIDED YOU (A) DO
 * NOT USE THE SOFTWARE AND (B) RETURN THE SOFTWARE WITHIN THIRTY (30) DAYS OF
 * YOUR INITIAL PURCHASE.
 *
 * IF YOU WISH TO USE THE SOFTWARE AS AN EMPLOYEE, CONTRACTOR, OR AGENT OF A
 * CORPORATION, PARTNERSHIP OR SIMILAR ENTITY, THEN YOU MUST BE AUTHORIZED TO SIGN
 * FOR AND BIND THE ENTITY IN ORDER TO ACCEPT THE TERMS OF THIS AGREEMENT. THE
 * LICENSES GRANTED UNDER THIS AGREEMENT ARE EXPRESSLY CONDITIONED UPON ACCEPTANCE
 * BY SUCH AUTHORIZED PERSONNEL.
 *
 * IF YOU HAVE ENTERED INTO A SEPARATE WRITTEN LICENSE AGREEMENT WITH AKIBAN FOR
 * USE OF THE SOFTWARE, THE TERMS AND CONDITIONS OF SUCH OTHER AGREEMENT SHALL
 * PREVAIL OVER ANY CONFLICTING TERMS OR CONDITIONS IN THIS AGREEMENT.
 */

/* The original from which this derives bore the following: */

/*

   Derby - Class org.apache.derby.impl.sql.compile.BinaryArithmeticOperatorNode

   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to you under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */

package com.akiban.sql.parser;

import com.akiban.sql.types.ValueClassName;

/**
 * This node represents a binary arithmetic operator, like + or *.
 *
 */

public class BinaryArithmeticOperatorNode extends BinaryOperatorNode
{
    /**
     * Initializer for a BinaryArithmeticOperatorNode
     *
     * @param leftOperand The left operand
     * @param rightOperand  The right operand
     */

    public void init(Object leftOperand, Object rightOperand) {
        super.init(leftOperand, rightOperand,
                   ValueClassName.NumberDataValue, ValueClassName.NumberDataValue);
    }

    public void setNodeType(int nodeType) {
        String operator = null;
        String methodName = null;

        switch (nodeType) {
        case NodeTypes.BINARY_DIVIDE_OPERATOR_NODE:
            operator = "/";
            methodName = "divide";
            break;

        case NodeTypes.BINARY_MINUS_OPERATOR_NODE:
            operator = "-";
            methodName = "minus";
            break;

        case NodeTypes.BINARY_PLUS_OPERATOR_NODE:
            operator = "+";
            methodName = "plus";
            break;

        case NodeTypes.BINARY_TIMES_OPERATOR_NODE:
            operator = "*";
            methodName = "times";
            break;

        case NodeTypes.MOD_OPERATOR_NODE:
            operator = "mod";
            methodName = "mod";
            break;

        case NodeTypes.BINARY_DIV_OPERATOR_NODE:
            operator = "div";
            methodName = "div";
            break;
            
        default:
            assert false : "Unexpected nodeType:" + nodeType;
        }
        setOperator(operator);
        setMethodName(methodName);
        super.setNodeType(nodeType);
    }

}

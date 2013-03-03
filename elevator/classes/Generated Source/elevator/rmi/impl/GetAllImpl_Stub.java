// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package elevator.rmi.impl;

public final class GetAllImpl_Stub
    extends java.rmi.server.RemoteStub
    implements elevator.rmi.GetAll, java.rmi.Remote
{
    private static final long serialVersionUID = 2;
    
    private static java.lang.reflect.Method $method_getDoor_0;
    private static java.lang.reflect.Method $method_getDoor_1;
    private static java.lang.reflect.Method $method_getDoors_2;
    private static java.lang.reflect.Method $method_getElevator_3;
    private static java.lang.reflect.Method $method_getElevator_4;
    private static java.lang.reflect.Method $method_getElevators_5;
    private static java.lang.reflect.Method $method_getMotor_6;
    private static java.lang.reflect.Method $method_getMotor_7;
    private static java.lang.reflect.Method $method_getMotors_8;
    private static java.lang.reflect.Method $method_getNumberOfElevators_9;
    private static java.lang.reflect.Method $method_getNumberOfFloors_10;
    private static java.lang.reflect.Method $method_getScale_11;
    private static java.lang.reflect.Method $method_getScale_12;
    private static java.lang.reflect.Method $method_getScales_13;
    private static java.lang.reflect.Method $method_getTopFloor_14;
    private static java.lang.reflect.Method $method_getVelocity_15;
    private static java.lang.reflect.Method $method_makeFloorListener_16;
    private static java.lang.reflect.Method $method_makeInsideListener_17;
    private static java.lang.reflect.Method $method_makePositionListener_18;
    private static java.lang.reflect.Method $method_makeVelocityListener_19;
    
    static {
	try {
	    $method_getDoor_0 = elevator.rmi.GetAll.class.getMethod("getDoor", new java.lang.Class[] {int.class});
	    $method_getDoor_1 = elevator.rmi.GetAll.class.getMethod("getDoor", new java.lang.Class[] {int[].class});
	    $method_getDoors_2 = elevator.rmi.GetAll.class.getMethod("getDoors", new java.lang.Class[] {});
	    $method_getElevator_3 = elevator.rmi.GetAll.class.getMethod("getElevator", new java.lang.Class[] {int.class});
	    $method_getElevator_4 = elevator.rmi.GetAll.class.getMethod("getElevator", new java.lang.Class[] {int[].class});
	    $method_getElevators_5 = elevator.rmi.GetAll.class.getMethod("getElevators", new java.lang.Class[] {});
	    $method_getMotor_6 = elevator.rmi.GetAll.class.getMethod("getMotor", new java.lang.Class[] {int.class});
	    $method_getMotor_7 = elevator.rmi.GetAll.class.getMethod("getMotor", new java.lang.Class[] {int[].class});
	    $method_getMotors_8 = elevator.rmi.GetAll.class.getMethod("getMotors", new java.lang.Class[] {});
	    $method_getNumberOfElevators_9 = elevator.rmi.GetAll.class.getMethod("getNumberOfElevators", new java.lang.Class[] {});
	    $method_getNumberOfFloors_10 = elevator.rmi.GetAll.class.getMethod("getNumberOfFloors", new java.lang.Class[] {});
	    $method_getScale_11 = elevator.rmi.GetAll.class.getMethod("getScale", new java.lang.Class[] {int.class});
	    $method_getScale_12 = elevator.rmi.GetAll.class.getMethod("getScale", new java.lang.Class[] {int[].class});
	    $method_getScales_13 = elevator.rmi.GetAll.class.getMethod("getScales", new java.lang.Class[] {});
	    $method_getTopFloor_14 = elevator.rmi.GetAll.class.getMethod("getTopFloor", new java.lang.Class[] {});
	    $method_getVelocity_15 = elevator.rmi.GetAll.class.getMethod("getVelocity", new java.lang.Class[] {});
	    $method_makeFloorListener_16 = elevator.rmi.GetAll.class.getMethod("makeFloorListener", new java.lang.Class[] {int.class, elevator.rmi.RemoteActionListener.class});
	    $method_makeInsideListener_17 = elevator.rmi.GetAll.class.getMethod("makeInsideListener", new java.lang.Class[] {int.class, elevator.rmi.RemoteActionListener.class});
	    $method_makePositionListener_18 = elevator.rmi.GetAll.class.getMethod("makePositionListener", new java.lang.Class[] {int.class, elevator.rmi.RemoteActionListener.class});
	    $method_makeVelocityListener_19 = elevator.rmi.GetAll.class.getMethod("makeVelocityListener", new java.lang.Class[] {elevator.rmi.RemoteActionListener.class});
	} catch (java.lang.NoSuchMethodException e) {
	    throw new java.lang.NoSuchMethodError(
		"stub class initialization failed");
	}
    }
    
    // constructors
    public GetAllImpl_Stub(java.rmi.server.RemoteRef ref) {
	super(ref);
    }
    
    // methods from remote interfaces
    
    // implementation of getDoor(int)
    public elevator.rmi.Door getDoor(int $param_int_1)
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getDoor_0, new java.lang.Object[] {new java.lang.Integer($param_int_1)}, -4583273140698499304L);
	    return ((elevator.rmi.Door) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getDoor(int[])
    public elevator.rmi.Door[] getDoor(int[] $param_arrayOf_int_1)
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getDoor_1, new java.lang.Object[] {$param_arrayOf_int_1}, 4173649084772303910L);
	    return ((elevator.rmi.Door[]) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getDoors()
    public elevator.rmi.Doors getDoors()
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getDoors_2, null, -1651000430118056322L);
	    return ((elevator.rmi.Doors) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getElevator(int)
    public elevator.rmi.Elevator getElevator(int $param_int_1)
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getElevator_3, new java.lang.Object[] {new java.lang.Integer($param_int_1)}, -607076168664886945L);
	    return ((elevator.rmi.Elevator) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getElevator(int[])
    public elevator.rmi.Elevator[] getElevator(int[] $param_arrayOf_int_1)
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getElevator_4, new java.lang.Object[] {$param_arrayOf_int_1}, 7178480077362880664L);
	    return ((elevator.rmi.Elevator[]) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getElevators()
    public elevator.rmi.Elevators getElevators()
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getElevators_5, null, -8430732934573415092L);
	    return ((elevator.rmi.Elevators) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getMotor(int)
    public elevator.rmi.Motor getMotor(int $param_int_1)
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getMotor_6, new java.lang.Object[] {new java.lang.Integer($param_int_1)}, -1570251501039906687L);
	    return ((elevator.rmi.Motor) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getMotor(int[])
    public elevator.rmi.Motor[] getMotor(int[] $param_arrayOf_int_1)
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getMotor_7, new java.lang.Object[] {$param_arrayOf_int_1}, 985472524968786728L);
	    return ((elevator.rmi.Motor[]) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getMotors()
    public elevator.rmi.Motors getMotors()
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getMotors_8, null, 4491631817782783494L);
	    return ((elevator.rmi.Motors) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getNumberOfElevators()
    public int getNumberOfElevators()
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getNumberOfElevators_9, null, 8408450840579129236L);
	    return ((java.lang.Integer) $result).intValue();
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getNumberOfFloors()
    public int getNumberOfFloors()
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getNumberOfFloors_10, null, -7897969397388344704L);
	    return ((java.lang.Integer) $result).intValue();
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getScale(int)
    public elevator.rmi.Scale getScale(int $param_int_1)
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getScale_11, new java.lang.Object[] {new java.lang.Integer($param_int_1)}, -4229158679999690547L);
	    return ((elevator.rmi.Scale) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getScale(int[])
    public elevator.rmi.Scale[] getScale(int[] $param_arrayOf_int_1)
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getScale_12, new java.lang.Object[] {$param_arrayOf_int_1}, 2937075690650203593L);
	    return ((elevator.rmi.Scale[]) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getScales()
    public elevator.rmi.Scales getScales()
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getScales_13, null, 6967548895668511556L);
	    return ((elevator.rmi.Scales) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getTopFloor()
    public int getTopFloor()
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getTopFloor_14, null, -7025154621275187875L);
	    return ((java.lang.Integer) $result).intValue();
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getVelocity()
    public double getVelocity()
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getVelocity_15, null, 5388204532774234915L);
	    return ((java.lang.Double) $result).doubleValue();
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of makeFloorListener(int, RemoteActionListener)
    public void makeFloorListener(int $param_int_1, elevator.rmi.RemoteActionListener $param_RemoteActionListener_2)
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_makeFloorListener_16, new java.lang.Object[] {new java.lang.Integer($param_int_1), $param_RemoteActionListener_2}, -3945602972699148578L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of makeInsideListener(int, RemoteActionListener)
    public void makeInsideListener(int $param_int_1, elevator.rmi.RemoteActionListener $param_RemoteActionListener_2)
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_makeInsideListener_17, new java.lang.Object[] {new java.lang.Integer($param_int_1), $param_RemoteActionListener_2}, -6941542500545117215L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of makePositionListener(int, RemoteActionListener)
    public void makePositionListener(int $param_int_1, elevator.rmi.RemoteActionListener $param_RemoteActionListener_2)
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_makePositionListener_18, new java.lang.Object[] {new java.lang.Integer($param_int_1), $param_RemoteActionListener_2}, -5332041590563260246L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of makeVelocityListener(RemoteActionListener)
    public void makeVelocityListener(elevator.rmi.RemoteActionListener $param_RemoteActionListener_1)
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_makeVelocityListener_19, new java.lang.Object[] {$param_RemoteActionListener_1}, 326847656548257038L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
}
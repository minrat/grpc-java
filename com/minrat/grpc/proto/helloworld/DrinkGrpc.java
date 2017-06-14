package com.minrat.grpc.proto.helloworld;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 * The drink service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.2.0)",
    comments = "Source: helloworld.proto")
public final class DrinkGrpc {

  private DrinkGrpc() {}

  public static final String SERVICE_NAME = "com.bocloud.grpc.proto.helloworld.Drink";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.minrat.grpc.proto.helloworld.DrinkRequest,
      com.minrat.grpc.proto.helloworld.DrinkReply> METHOD_HAVE_DRINK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.bocloud.grpc.proto.helloworld.Drink", "HaveDrink"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.minrat.grpc.proto.helloworld.DrinkRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.minrat.grpc.proto.helloworld.DrinkReply.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DrinkStub newStub(io.grpc.Channel channel) {
    return new DrinkStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DrinkBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DrinkBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static DrinkFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DrinkFutureStub(channel);
  }

  /**
   * <pre>
   * The drink service definition.
   * </pre>
   */
  public static abstract class DrinkImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void haveDrink(com.minrat.grpc.proto.helloworld.DrinkRequest request,
        io.grpc.stub.StreamObserver<com.minrat.grpc.proto.helloworld.DrinkReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_HAVE_DRINK, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_HAVE_DRINK,
            asyncUnaryCall(
              new MethodHandlers<
                com.minrat.grpc.proto.helloworld.DrinkRequest,
                com.minrat.grpc.proto.helloworld.DrinkReply>(
                  this, METHODID_HAVE_DRINK)))
          .build();
    }
  }

  /**
   * <pre>
   * The drink service definition.
   * </pre>
   */
  public static final class DrinkStub extends io.grpc.stub.AbstractStub<DrinkStub> {
    private DrinkStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DrinkStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DrinkStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DrinkStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void haveDrink(com.minrat.grpc.proto.helloworld.DrinkRequest request,
        io.grpc.stub.StreamObserver<com.minrat.grpc.proto.helloworld.DrinkReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_HAVE_DRINK, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The drink service definition.
   * </pre>
   */
  public static final class DrinkBlockingStub extends io.grpc.stub.AbstractStub<DrinkBlockingStub> {
    private DrinkBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DrinkBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DrinkBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DrinkBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.minrat.grpc.proto.helloworld.DrinkReply haveDrink(com.minrat.grpc.proto.helloworld.DrinkRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_HAVE_DRINK, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The drink service definition.
   * </pre>
   */
  public static final class DrinkFutureStub extends io.grpc.stub.AbstractStub<DrinkFutureStub> {
    private DrinkFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DrinkFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DrinkFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DrinkFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.minrat.grpc.proto.helloworld.DrinkReply> haveDrink(
        com.minrat.grpc.proto.helloworld.DrinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_HAVE_DRINK, getCallOptions()), request);
    }
  }

  private static final int METHODID_HAVE_DRINK = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DrinkImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DrinkImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HAVE_DRINK:
          serviceImpl.haveDrink((com.minrat.grpc.proto.helloworld.DrinkRequest) request,
              (io.grpc.stub.StreamObserver<com.minrat.grpc.proto.helloworld.DrinkReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class DrinkDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.minrat.grpc.proto.helloworld.HelloWorldProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DrinkGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DrinkDescriptorSupplier())
              .addMethod(METHOD_HAVE_DRINK)
              .build();
        }
      }
    }
    return result;
  }
}

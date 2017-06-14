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
 *The Dinner service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.2.0)",
    comments = "Source: helloworld.proto")
public final class DinnerGrpc {

  private DinnerGrpc() {}

  public static final String SERVICE_NAME = "com.bocloud.grpc.proto.helloworld.Dinner";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.minrat.grpc.proto.helloworld.DinnerRequest,
      com.minrat.grpc.proto.helloworld.DinnerReply> METHOD_HAVE_DINNER =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.bocloud.grpc.proto.helloworld.Dinner", "HaveDinner"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.minrat.grpc.proto.helloworld.DinnerRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.minrat.grpc.proto.helloworld.DinnerReply.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DinnerStub newStub(io.grpc.Channel channel) {
    return new DinnerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DinnerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DinnerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static DinnerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DinnerFutureStub(channel);
  }

  /**
   * <pre>
   *The Dinner service definition.
   * </pre>
   */
  public static abstract class DinnerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void haveDinner(com.minrat.grpc.proto.helloworld.DinnerRequest request,
        io.grpc.stub.StreamObserver<com.minrat.grpc.proto.helloworld.DinnerReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_HAVE_DINNER, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_HAVE_DINNER,
            asyncUnaryCall(
              new MethodHandlers<
                com.minrat.grpc.proto.helloworld.DinnerRequest,
                com.minrat.grpc.proto.helloworld.DinnerReply>(
                  this, METHODID_HAVE_DINNER)))
          .build();
    }
  }

  /**
   * <pre>
   *The Dinner service definition.
   * </pre>
   */
  public static final class DinnerStub extends io.grpc.stub.AbstractStub<DinnerStub> {
    private DinnerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DinnerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DinnerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DinnerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void haveDinner(com.minrat.grpc.proto.helloworld.DinnerRequest request,
        io.grpc.stub.StreamObserver<com.minrat.grpc.proto.helloworld.DinnerReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_HAVE_DINNER, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *The Dinner service definition.
   * </pre>
   */
  public static final class DinnerBlockingStub extends io.grpc.stub.AbstractStub<DinnerBlockingStub> {
    private DinnerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DinnerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DinnerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DinnerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.minrat.grpc.proto.helloworld.DinnerReply haveDinner(com.minrat.grpc.proto.helloworld.DinnerRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_HAVE_DINNER, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *The Dinner service definition.
   * </pre>
   */
  public static final class DinnerFutureStub extends io.grpc.stub.AbstractStub<DinnerFutureStub> {
    private DinnerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DinnerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DinnerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DinnerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.minrat.grpc.proto.helloworld.DinnerReply> haveDinner(
        com.minrat.grpc.proto.helloworld.DinnerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_HAVE_DINNER, getCallOptions()), request);
    }
  }

  private static final int METHODID_HAVE_DINNER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DinnerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DinnerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HAVE_DINNER:
          serviceImpl.haveDinner((com.minrat.grpc.proto.helloworld.DinnerRequest) request,
              (io.grpc.stub.StreamObserver<com.minrat.grpc.proto.helloworld.DinnerReply>) responseObserver);
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

  private static final class DinnerDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.minrat.grpc.proto.helloworld.HelloWorldProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DinnerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DinnerDescriptorSupplier())
              .addMethod(METHOD_HAVE_DINNER)
              .build();
        }
      }
    }
    return result;
  }
}

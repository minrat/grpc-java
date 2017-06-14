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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.2.0)",
    comments = "Source: helloworld.proto")
public final class GoodByeGrpc {

  private GoodByeGrpc() {}

  public static final String SERVICE_NAME = "com.bocloud.grpc.proto.helloworld.GoodBye";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.minrat.grpc.proto.helloworld.ByeRequest,
      com.minrat.grpc.proto.helloworld.ByeReply> METHOD_SAY_BYE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.bocloud.grpc.proto.helloworld.GoodBye", "SayBye"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.minrat.grpc.proto.helloworld.ByeRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.minrat.grpc.proto.helloworld.ByeReply.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GoodByeStub newStub(io.grpc.Channel channel) {
    return new GoodByeStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GoodByeBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GoodByeBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static GoodByeFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GoodByeFutureStub(channel);
  }

  /**
   */
  public static abstract class GoodByeImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void sayBye(com.minrat.grpc.proto.helloworld.ByeRequest request,
        io.grpc.stub.StreamObserver<com.minrat.grpc.proto.helloworld.ByeReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SAY_BYE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SAY_BYE,
            asyncUnaryCall(
              new MethodHandlers<
                com.minrat.grpc.proto.helloworld.ByeRequest,
                com.minrat.grpc.proto.helloworld.ByeReply>(
                  this, METHODID_SAY_BYE)))
          .build();
    }
  }

  /**
   */
  public static final class GoodByeStub extends io.grpc.stub.AbstractStub<GoodByeStub> {
    private GoodByeStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GoodByeStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GoodByeStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GoodByeStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void sayBye(com.minrat.grpc.proto.helloworld.ByeRequest request,
        io.grpc.stub.StreamObserver<com.minrat.grpc.proto.helloworld.ByeReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SAY_BYE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GoodByeBlockingStub extends io.grpc.stub.AbstractStub<GoodByeBlockingStub> {
    private GoodByeBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GoodByeBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GoodByeBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GoodByeBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.minrat.grpc.proto.helloworld.ByeReply sayBye(com.minrat.grpc.proto.helloworld.ByeRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SAY_BYE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GoodByeFutureStub extends io.grpc.stub.AbstractStub<GoodByeFutureStub> {
    private GoodByeFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GoodByeFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GoodByeFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GoodByeFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.minrat.grpc.proto.helloworld.ByeReply> sayBye(
        com.minrat.grpc.proto.helloworld.ByeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SAY_BYE, getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_BYE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GoodByeImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GoodByeImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_BYE:
          serviceImpl.sayBye((com.minrat.grpc.proto.helloworld.ByeRequest) request,
              (io.grpc.stub.StreamObserver<com.minrat.grpc.proto.helloworld.ByeReply>) responseObserver);
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

  private static final class GoodByeDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.minrat.grpc.proto.helloworld.HelloWorldProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GoodByeGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GoodByeDescriptorSupplier())
              .addMethod(METHOD_SAY_BYE)
              .build();
        }
      }
    }
    return result;
  }
}
